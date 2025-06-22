package com.auth.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.auth.jwt.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
