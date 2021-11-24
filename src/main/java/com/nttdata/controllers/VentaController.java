package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Venta;
import com.nttdata.services.VentaService;

@Service
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@RequestMapping("")
	public String ventaHome() {
		return "venta.jsp";
	}
	
	@RequestMapping("/add")
	public String agregar(Model model, @Valid @ModelAttribute Venta venta) {
		if(venta!=null) {
			model.addAttribute("venta", venta);
			ventaService.agregar(venta);
			return "redirect:/venta/lista";
		}
		return "redirect:/venta";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Venta venta = ventaService.obtenerVenta(id);
		if(venta!=null) {
			model.addAttribute("venta", venta);
			return "editVenta.jsp";
		}
		return "redirect:/venta/lista";
	}
	
	@RequestMapping("/editarVenta")
	public String editarVenta(@Valid @ModelAttribute Venta venta) {
		ventaService.editar(venta);
		return "redirect:/venta/lista";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Venta venta= ventaService.obtenerVenta(id);
		if(venta!=null) {
			ventaService.eliminar(venta);
		}
		return "redirect:/venta/lista";
	}
	
	@RequestMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("listaVentas", ventaService.listar());
		return "listaVentas.jsp";
	}
}
