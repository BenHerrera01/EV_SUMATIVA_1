package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository ;
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public void agregar(Usuario usuario) {
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
	

}
