package com.finanzas.personal.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.personal.Model.Egresos;
import com.finanzas.personal.Repository.EgresosRepository;

@Service
public class EgresosService {
		
	@Autowired
	private EgresosRepository repos;
	
	public List<Egresos> LoadExpenses(){
		return repos.findAll();
	}
}
