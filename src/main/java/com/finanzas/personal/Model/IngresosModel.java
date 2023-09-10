package com.finanzas.personal.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="ingresos")
public class IngresosModel {
		
		@Id
		@Column(name="id")
		public Long id;
		
		@Column(name="fecha")
		public Date fecha;
		
		@Column(name="Descripcion")
		public String Descripcion;
		
		@Column(name="monto")
		public double monto;
		
		@Column(name="tipo_ingreso")
		public int tipo_ingreso;
		
		@Column(name="id_cartera")
		public int id_cartera;
		
}
