package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> obtenerRoles(){
		return roleRepository.findAll();
	}
	
	public void insertar(Role role) {
		roleRepository.save(role);
	}
	
	public List<Role> encontrarPorNombre(String nombre){
		return roleRepository.findByNombre(nombre);
	}
}
