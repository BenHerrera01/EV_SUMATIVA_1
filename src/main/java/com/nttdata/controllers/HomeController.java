package com.nttdata.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.services.CarritoService;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
public class HomeController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	CarritoService carritoService;
	
	private int cantidad;
	
	@GetMapping({"/home","/"})
	public String home(Model model, Principal principal) {
		Carrito carrito = carritoService.obtenerCarritoUsuario(principal.getName());
		if(carrito!=null) {
			cantidad = carrito.getProductos().size();
			model.addAttribute("cantidadProductos", cantidad);
		} 
		model.addAttribute("listaProductos", productoService.listar());
		model.addAttribute("listaCategorias", categoriaService.listar());
		model.addAttribute("nombre", principal.getName());
		return "home.jsp";
	}
	
	@GetMapping("/busquedaCategoria")
	public String listarPorCategoria(Model model, @RequestParam("categoria") String categoria, Principal principal) {
		if(categoria.equals("")) {
			return "redirect:/home";
		}
		List<Producto> listaProductos = productoService.obtenerPorCategoria(categoria);
		model.addAttribute("listaCategorias", categoriaService.listar());
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("nombre", principal.getName());
		return "home.jsp";
	}
	
	@GetMapping("/busquedaKeyword")
	public String listarPorKeyword(Model model, @RequestParam("keyword") String keyword, Principal principal) {
		if(keyword.equals("")) {
			return "redirect:/home";
		}
		List<Producto> listaProductos = productoService.obtenerPorPalabraClave(keyword);
		model.addAttribute("listaCategorias", categoriaService.listar());
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("nombre", principal.getName());
		return "home.jsp";
	}
	
	@GetMapping("/busquedaCategoriaDinamica")
	public String listarPorCategoriaDinamica(Model model, @RequestParam("nombreCategoria") String nombreCategoria, Principal principal) {
		if(nombreCategoria.equals("")) {
			return "redirect:/home";
		}
		List<Producto> listaProductos = productoService.obtenerPorCategoriaDinamica(nombreCategoria);
		model.addAttribute("listaCategorias", categoriaService.listar());
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("nombre", principal.getName());
		return "home.jsp";
	}
	
	
	
}
	

