package com.auth.jwt.dto;

public class ServicioDto {
	    private String especialidad;
	    private String medico;
	    private Double precio;

	    public ServicioDto() {}

	    public ServicioDto(String especialidad, String medico, Double precio) {
	        this.especialidad = especialidad;
	        this.medico = medico;
	        this.precio = precio;
	    }

		public String getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
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

	    
	}

