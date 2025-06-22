package com.auth.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.auth.jwt.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

}