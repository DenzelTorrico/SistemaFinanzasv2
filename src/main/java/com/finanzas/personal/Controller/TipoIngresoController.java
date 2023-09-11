package com.finanzas.personal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finanzas.personal.Services.TipoIngresoService;

@Controller
public class TipoIngresoController {
		
		@Autowired
		private TipoIngresoService service;
		
		@GetMapping("/tipoingreso")
		public String Index(Model model) {
				
			var data = service.LoadTypeIncome();
			model.addAttribute("data", data);
			return "tipoingresos";
		}
}
