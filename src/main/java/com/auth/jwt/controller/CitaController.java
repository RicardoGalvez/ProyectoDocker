package com.auth.jwt.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.dto.CitaDto;
import com.auth.jwt.model.Cita;
import com.auth.jwt.repository.CitaRepository;
import com.auth.jwt.repository.ServicioRepository;
import com.auth.jwt.model.Servicio;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @PostMapping
    public ResponseEntity<?> crearCita(@RequestBody CitaDto dto) {
        Optional<Servicio> optServicio = servicioRepository.findById(dto.getServicioId());
        if (optServicio.isEmpty()) {
            return ResponseEntity.badRequest().body("Servicio no encontrado");
        }

        Cita cita = new Cita();
        cita.setPaciente(dto.getPaciente());
        cita.setFecha(dto.getFecha());
        cita.setServicio(optServicio.get());

        return ResponseEntity.ok(citaRepository.save(cita));
    }
    
    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCita(@PathVariable Long id) {
        if (!citaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        citaRepository.deleteById(id);
        return ResponseEntity.ok("Cita eliminada correctamente.");
    }


}
