package com.finanzas.personal.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ingresos")
public class IngresosModel {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "fecha", nullable = false)
    public Date fecha;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    public String descripcion;

    @Column(name = "monto", nullable = false)
    public Double monto;

    @ManyToOne
    @JoinColumn(name = "tipo_ingreso", referencedColumnName = "id", nullable = false)
    public TipoIngreso tipoIngreso;

    @ManyToOne
    @JoinColumn(name = "id_cartera", referencedColumnName = "id", nullable = false)
    public Cartera cartera;
		
}
