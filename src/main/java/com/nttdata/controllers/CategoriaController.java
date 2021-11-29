package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String categoriaHome(Model model) {
		model.addAttribute("listaProductos", productoService.listar());
		model.addAttribute("listaCategorias", categoriaService.listar());
		return "producto.jsp";
	}
	
	@RequestMapping("/add")
	public String crear(@Valid @ModelAttribute Categoria categoria, Model model) {
		if(categoria!=null) {
			model.addAttribute("categoria", categoria);
			categoriaService.agregar(categoria);
		}
		
		return "redirect:/producto";
	}
}
