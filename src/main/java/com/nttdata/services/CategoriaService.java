package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Categoria;
import com.nttdata.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public void agregar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
}
