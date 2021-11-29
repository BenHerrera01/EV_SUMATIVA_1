package com.nttdata.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String productoHome(Model model) {
		model.addAttribute("listaProductos", productoService.listar());
		model.addAttribute("listaCategorias", categoriaService.listar());
		return "producto.jsp";
	}
	
	@RequestMapping("/add")
	public String agregar(Model model, @Valid @ModelAttribute Producto producto, BindingResult binding, RedirectAttributes ra) {
		if(producto!=null) {
			if(binding.hasErrors()) {
				List<String> errores = binding.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
				ra.addFlashAttribute("errores", errores);
				return "redirect:/producto";
			}
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
			model.addAttribute("listaCategorias", categoriaService.listar());
			return "editProductos.jsp";
		}
		return "redirect:/producto/lista";
	}
	
	@RequestMapping("/editarProducto")
	public String editarProducto(@Valid @ModelAttribute Producto producto, BindingResult binding, RedirectAttributes ra) {
		if(binding.hasErrors()) {
			List<String> errores = binding.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			ra.addFlashAttribute("errores", errores);
			return "redirect:/producto/editar/"+producto.getId();
		}
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
		for (Producto prod : productoService.obtenerPorPalabraClave("headset")) {
			System.out.println(prod.getNombre());
		}
		
		model.addAttribute("listaProductos", productoService.listar());
		return "listaProductos.jsp";
	}

}
