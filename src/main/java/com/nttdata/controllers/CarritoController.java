package com.nttdata.controllers;




import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.services.CarritoService;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	UsuarioService usuarioService;

	private List<Producto> productosCarro = new ArrayList<Producto>();
	private Carrito carrito;
	
	@GetMapping("/agregar/{id}")
	public String agregarProductoCarrito(Model model, @PathVariable Long id, Principal principal) {
		
		carrito = carritoService.obtenerCarritoUsuario(principal.getName());
		if(carrito == null) {
			productosCarro.clear();
			carrito = new Carrito();
			carrito.setUsuario(usuarioService.findByEmail(principal.getName()));
		}
			
		Producto producto = productoService.obtenerProducto(id);
		productosCarro.add(producto);
		carrito.setProductos(productosCarro);
		carrito.setTotal(carritoService.obtenerTotal(productosCarro));
		carritoService.insertar(carrito);
		
		model.addAttribute("cantidad", productosCarro.size());
		return "redirect:/home";
	}
	
	@GetMapping("/ver")
	public String verCarrito(Model model, Principal principal) {
		carrito = carritoService.obtenerCarritoUsuario(principal.getName());
		if(carrito == null) {
			carrito = new Carrito();
			carrito.setUsuario(usuarioService.findByEmail(principal.getName()));
			productosCarro.clear();
		}
		if(carrito.getUsuario().getEmail().equals(principal.getName())) {
			model.addAttribute("productos", productosCarro);
			model.addAttribute("total", carritoService.obtenerTotal(productosCarro));
			model.addAttribute("cantidad", productosCarro.size());
			model.addAttribute("nombre", principal.getName());
			return "carrito.jsp";
		}
		return "redirect:/home";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String borrarProducto(Model model, @PathVariable Long id) {
		Producto producto = productoService.obtenerProducto(id);
		List<Producto> copiaLista = new ArrayList<Producto>(productosCarro);
		for (Producto productoCarrito : copiaLista) {
			if(productoCarrito.getNombre().equals(producto.getNombre())) {
				productosCarro.remove(productoCarrito);
				carrito.setProductos(productosCarro);
				break;
			}
		}
		carrito.setTotal(carritoService.obtenerTotal(productosCarro));
		carritoService.editar(carrito);
		return "redirect:/carrito/ver";
	}
	
	@RequestMapping("/pagar")
	public String pagar(@ModelAttribute Carrito carritol, Principal principal) {
		carrito = carritoService.obtenerCarritoUsuario(principal.getName());
		carritoService.eliminar(carrito);
		productosCarro.clear();
		return "redirect:/home";
	}
	
}
