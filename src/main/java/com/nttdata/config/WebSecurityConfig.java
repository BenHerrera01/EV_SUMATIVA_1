package com.nttdata.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws	Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	 public void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/home","/carrito/**").hasAuthority("USER_ROLE")
				.antMatchers("/producto/**").hasAuthority("ADMIN_ROLE")
				.antMatchers("/login","/registro").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
				.successHandler(customAuthenticationSuccessHandler)
				.failureUrl("/login?error=true")
				.usernameParameter("email").passwordParameter("password");
	 http.headers().cacheControl();
	 }

	
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	public WebSecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
		this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
	}
	
	
	
	@Bean
	 public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	 }
}
