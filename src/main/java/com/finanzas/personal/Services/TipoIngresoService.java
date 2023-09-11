package com.finanzas.personal.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.personal.Model.TipoIngreso;
import com.finanzas.personal.Repository.TipoIngresoRepository;

@Service
public class TipoIngresoService {
		
		@Autowired
		TipoIngresoRepository repos;
	
		public List<TipoIngreso> LoadTypeIncome(){
			return repos.findAll();
		}
}
