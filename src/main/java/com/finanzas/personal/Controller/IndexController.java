package com.finanzas.personal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finanzas.personal.Services.IngresoService;


@Controller
public class IndexController {
			
		@Autowired
		private IngresoService ingresos;
	
		@GetMapping("/home")
		public String Index(Model modelo) {
			var data = ingresos.LoadIngresos();
			modelo.addAttribute("data", data);
			return "index";
		}
}
