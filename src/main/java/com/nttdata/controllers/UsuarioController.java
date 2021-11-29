package com.nttdata.controllers;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@GetMapping("/registro")
	public String registroForm(Model model) {
		return "registro.jsp";
	}
	
	@PostMapping("/registro")
	public String registrar(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult binding, RedirectAttributes ra) {
		if(usuario!=null) {
			if(binding.hasErrors()) {
				ra.addFlashAttribute("error", "Error en alguno de los campos");
				return "redirect:/registro";
			} else if(!usuario.getPassword().equals(usuario.getPasswordConfirmation()) || usuario.getPassword().length()<3 || usuario.getPassword().length()>15) {
				ra.addFlashAttribute("error", "Passwords no coinciden o estan fuera de limite");
				return "redirect:/registro";
			} else if(usuarioService.usuarioExiste(usuario.getEmail())) {
				ra.addFlashAttribute("error", "Correo ya registrado");
				return "redirect:/registro";
			}
			usuarioService.agregar(usuario);
			return "redirect:/login";
		}
		return "redirect:/registro";
	}

	
	@RequestMapping("usuario/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.obtenerUsuario(id);
		if(usuario!=null) {
			model.addAttribute("usuario", usuario);
			return "editUsuarios.jsp";
		}
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("usuario/editarUsuario")
	public String editarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult binding, RedirectAttributes ra) {
		if(binding.hasErrors()) {
			List<String> errores = binding.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			ra.addFlashAttribute("errores", errores);
			return "redirect:/usuario/editar/"+usuario.getId();
		} else if(!usuario.getPassword().equals(usuario.getPasswordConfirmation()) || usuario.getPassword().length()<3 || usuario.getPassword().length()>15) {
			ra.addFlashAttribute("errores", "Passwords no coinciden o estan fuera de limite");
			return "redirect:/usuario/editar/"+usuario.getId();
		}
		usuarioService.editar(usuario);
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("usuario/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Usuario usuario = usuarioService.obtenerUsuario(id);
		if(usuario!=null) {
			usuarioService.eliminar(usuario);
		}
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("usuario/lista")
	public String listar(Model model, Principal principal) {
		model.addAttribute("userEmail", principal.getName());
		model.addAttribute("listaUsuarios", usuarioService.listar());
		return "listaUsuarios.jsp";
	}
}
