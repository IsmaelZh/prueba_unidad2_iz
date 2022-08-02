package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IGestorCitaMedicaService {

	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugarCita,
			String cedulaDorctor, String cedulaPaciente);
	
	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);
	
	public List<PacienteSencillo> reportePacientes (LocalDateTime fecha, String genero);
	
	

}
