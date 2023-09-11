package com.finanzas.personal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.personal.Model.Egresos;

public interface EgresosRepository extends JpaRepository<Egresos,Long> {

}
