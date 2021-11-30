package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
		
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) throw new UsernameNotFoundException(email);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role rol : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return new User(usuario.getEmail(), usuario.getPassword(),authorities);
	}

}
