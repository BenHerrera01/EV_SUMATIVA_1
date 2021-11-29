package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository ;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public void agregar(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		String role = usuario.getRole();
		if(role.equals("ADMIN_ROLE")) {
			usuario.setRole("ADMIN_ROLE");
		} else {
			usuario.setRole("USER_ROLE");
		}
		usuarioRepository.save(usuario);
	}
	
	public void editar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void eliminar(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public Usuario obtenerUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public boolean usuarioExiste(String email) {
		boolean existe = true;
		if(usuarioRepository.findByEmail(email)==null) {
			existe = false;
		}
		return existe;
	}


}
