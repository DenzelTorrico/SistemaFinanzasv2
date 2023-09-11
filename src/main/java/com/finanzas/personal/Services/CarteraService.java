package com.finanzas.personal.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.personal.Model.Cartera;
import com.finanzas.personal.Repository.CarteraRepository;

@Service
public class CarteraService {
	
	@Autowired
	CarteraRepository repos;
		
	public Cartera LoadCartera(){
		return repos.findById((long) 1).get();
	}
	
}
