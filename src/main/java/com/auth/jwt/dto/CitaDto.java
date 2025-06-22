package com.auth.jwt.dto;

import java.time.LocalDate;

public class CitaDto {
    private String paciente;
    private LocalDate fecha;
    private Long servicioId;
    // Getters y setters
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Long getServicioId() {
		return servicioId;
	}
	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
	}
}
