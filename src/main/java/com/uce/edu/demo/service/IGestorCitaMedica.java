package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.PacienteSencillo;

public interface IGestorCitaMedica {

	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugarCita,
			String cedulaDorctor, String cedulaPaciente);
	
	public List<PacienteSencillo> reportePacientes (LocalDateTime fecha, String genero);

}
