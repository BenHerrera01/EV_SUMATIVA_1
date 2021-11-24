package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.services.VentaService;

@Service
@RequestMapping("venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
}
