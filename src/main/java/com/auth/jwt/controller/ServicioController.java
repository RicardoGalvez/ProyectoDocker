package com.auth.jwt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.dto.ServicioDto;
import com.auth.jwt.model.Servicio;
import com.auth.jwt.repository.ServicioRepository;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ServicioDto dto) {
        try {
            Servicio servicio = new Servicio();
            servicio.setEspecialidad(dto.getEspecialidad());
            servicio.setMedico(dto.getMedico());
            servicio.setPrecio(dto.getPrecio());
            Servicio guardado = servicioRepository.save(servicio);
            return ResponseEntity.ok(guardado);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body("Ya existe un servicio con esa especialidad y médico.");
        }
    }

    @GetMapping
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }
}