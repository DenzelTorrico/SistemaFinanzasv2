package com.finanzas.personal.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.finanzas.personal.Model.Cartera;
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
		@GetMapping("/egresos/add")
		public String Egresos(Model modelo) {
			com.finanzas.personal.Model.Egresos egreso = new com.finanzas.personal.Model.Egresos();
			modelo.addAttribute("egreso", egreso);
			return "egresos/add";
		}
		@PostMapping("egresos/add")
		public String Add(@ModelAttribute com.finanzas.personal.Model.Egresos request) {
			 /*ingresos.Insertar(request);

			    // Obtén la cartera actual
			    Optional<Cartera> optionalCartera = cartera.findById(request.cartera.id);

			    if (optionalCartera.isPresent()) {
			        Cartera carteraActual = optionalCartera.get();

			        // Suma request.monto al valor actual de dinero
			        double nuevoSaldo = carteraActual.getDinero()+request.getMonto();

			        // Actualiza el campo dinero en la cartera
			        carteraActual.setDinero(nuevoSaldo);

			        // Guarda la cartera actualizada en la base de datos
			        cartera.save(carteraActual);
			    }*/
			return "redirect:/egresos";
		}
}
