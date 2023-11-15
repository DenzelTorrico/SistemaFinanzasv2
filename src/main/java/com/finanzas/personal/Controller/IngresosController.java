package com.finanzas.personal.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finanzas.personal.Model.Cartera;
import com.finanzas.personal.Model.IngresosModel;
import com.finanzas.personal.Repository.CarteraRepository;
import com.finanzas.personal.Services.CarteraService;
import com.finanzas.personal.Services.IngresoService;
import com.finanzas.personal.Services.TipoIngresoService;

@Controller
public class IngresosController {
	@Autowired
	private IngresoService ingresos;
	
	@Autowired
	private CarteraRepository cartera;
	
	@Autowired
	private TipoIngresoService typeingresos;
	
	@GetMapping("/ingresos")
	public String Index(Model modelo) {
		var data = ingresos.LoadIngresos();
		modelo.addAttribute("data", data);
		return "ingresos/index";
	}
	@GetMapping("/ingresos/add")
	public String AddIncome(Model modelo) {
		
		var tipos = typeingresos.LoadTypeIncome();
		IngresosModel ingreso = new IngresosModel();
		modelo.addAttribute("ingreso", ingreso);
		modelo.addAttribute("tipos", tipos);
		return "ingresos/add";
	}
	@PostMapping("ingresos/add")
	public String AddIncomePost(@ModelAttribute  IngresosModel request) {
		 ingresos.Insertar(request);

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
		    }
		
		return "redirect:/ingresos";
	    //Suponiendo que Cartera tiene un constructor que acepta un Long como ID
        //return ResponseEntity.ok("Datos"+ request.cartera.dinero);

	}
}
