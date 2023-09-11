package com.finanzas.personal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finanzas.personal.Services.EgresosService;

@Controller
public class EgresosController {
			
		@Autowired
		private EgresosService service;
	
		@GetMapping("/egresos")
		public String Index(Model modelo) {
			var data = service.LoadExpenses();
			modelo.addAttribute("data", data);
			return "egresos";
		}
}
