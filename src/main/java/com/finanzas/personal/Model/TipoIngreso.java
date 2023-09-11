package com.finanzas.personal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_ingreso")
public class TipoIngreso {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", length = 100, nullable = false)
	    public String name;

	    @Column(name = "descripcion", columnDefinition = "TEXT")
	    private String descripcion;
}
