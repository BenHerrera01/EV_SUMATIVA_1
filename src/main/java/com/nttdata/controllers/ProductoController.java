package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Producto;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String productoHome() {
		return "producto.jsp";
	}
	
	@RequestMapping("/add")
	public String agregar(Model model, @Valid @ModelAttribute Producto producto) {
		if(producto!=null) {
			model.addAttribute("producto", producto);
			productoService.agregar(producto);
			return "redirect:/producto/lista";
		}
		return "redirect:/producto";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Producto producto = productoService.obtenerProducto(id);
		if(producto!=null) {
			model.addAttribute("producto", producto);
			return "editProductos.jsp";
		}
		return "redirect:/producto/lista";
	}
	
	@RequestMapping("/editarProducto")
	public String editarProducto(@Valid @ModelAttribute Producto producto) {
		productoService.editar(producto);
		return "redirect:/producto/lista";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Producto producto = productoService.obtenerProducto(id);
		if(producto!=null) {
			productoService.eliminar(producto);
		}
		return "redirect:/producto/lista";
	}
	
	@RequestMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("listaProductos", productoService.listar());
		return "listaProductos.jsp";
	}
}
