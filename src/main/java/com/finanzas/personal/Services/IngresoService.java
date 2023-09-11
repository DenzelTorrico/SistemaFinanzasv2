package com.finanzas.personal.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.personal.Model.IngresosModel;
import com.finanzas.personal.Repository.IngresoRepository;

@Service
public class IngresoService {
	
	@Autowired
	private IngresoRepository repos;
	
	public List<IngresosModel> LoadIngresos(){
		return repos.findAll();
	}
}
