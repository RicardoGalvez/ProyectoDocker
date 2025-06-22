package com.auth.jwt.model;

import jakarta.persistence.*;

@Entity
@Table(
	    uniqueConstraints = @UniqueConstraint(columnNames = {"especialidad", "medico"})
	)
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especialidad;
    private String medico;
    private Double precio;

    public Servicio() {}

    public Servicio(String especialidad, String medico, Double precio) {
        this.especialidad = especialidad;
        this.medico = medico;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

    
}
