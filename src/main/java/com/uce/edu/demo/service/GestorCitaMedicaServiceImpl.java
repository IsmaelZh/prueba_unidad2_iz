package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepo;
import com.uce.edu.demo.repository.IDoctorRepo;
import com.uce.edu.demo.repository.IPacienteRepo;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Autowired
	private IPacienteRepo iPacienteRepo;

	@Autowired
	private ICitaMedicaRepo iCitaMedicaRepo;

	@Override
	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugarCita,
			String cedulaDorctor, String cedulaPaciente) {
		// TODO Auto-generated method stub

		Doctor doctor = this.doctorRepo.buscarPorCedula(cedulaDorctor);
		Paciente paciente = this.iPacienteRepo.buscarPorCedula(cedulaPaciente);

		CitaMedica cita = new CitaMedica();
		cita.setNumeroCita(numeroCita);
		cita.setFechaCita(fechaCita);
		cita.setValorCita(valor);
		cita.setLugarCita(lugarCita);
		cita.setPaciente(paciente);
		cita.setDoctor(doctor);

		this.iCitaMedicaRepo.insertar(cita);

	}

	@Override
	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		// TODO Auto-generated method stub

	        CitaMedica cita = this.iCitaMedicaRepo.buscarPorNumero(numero);
	        cita.setDiagnostico(diagnostico);
	        cita.setReceta(receta);
	        cita.setFechaProximaCita(fechaProxima);

	        this.iCitaMedicaRepo.actualizar(cita);

	    }
		

	@Override
	public List<PacienteSencillo> reportePacientes(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepo.reportePacientes(fecha, genero);
	}

}
