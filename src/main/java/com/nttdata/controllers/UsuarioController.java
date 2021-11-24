package com.nttdata.controllers;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String usuarioHome() {
		return "usuario.jsp";
	}
	
	@RequestMapping("/add")
	public String agregar(Model model, @Valid @ModelAttribute Usuario usuario) {
		if(usuario!=null) {
			model.addAttribute("usuario", usuario);
			usuarioService.agregar(usuario);
			return "redirect:/usuario/lista";
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.obtenerUsuario(id);
		if(usuario!=null) {
			model.addAttribute("usuario", usuario);
			return "editUsuarios.jsp";
		}
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("/editarUsuario")
	public String editarUsuario(@Valid @ModelAttribute Usuario usuario) {
		usuarioService.editar(usuario);
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Usuario usuario = usuarioService.obtenerUsuario(id);
		if(usuario!=null) {
			usuarioService.eliminar(usuario);
		}
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("listaUsuarios", usuarioService.listar());
		return "listaUsuarios.jsp";
	}
}
