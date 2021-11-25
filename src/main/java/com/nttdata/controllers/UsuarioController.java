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
	public String agregar(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult binding, RedirectAttributes ra) {
		if(usuario!=null) {
			if(binding.hasErrors()) {
				List<String> errores = binding.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
				ra.addFlashAttribute("errores", errores);
				return "redirect:/usuario";
			}
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
	public String editarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult binding, RedirectAttributes ra) {
		if(binding.hasErrors()) {
			List<String> errores = binding.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			ra.addFlashAttribute("errores", errores);
			return "redirect:/usuario/editar/"+usuario.getId();
		}
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
