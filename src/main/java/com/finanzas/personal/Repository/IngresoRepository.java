package com.finanzas.personal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.personal.Model.IngresosModel;

public interface IngresoRepository extends JpaRepository<IngresosModel,Long> {

}
