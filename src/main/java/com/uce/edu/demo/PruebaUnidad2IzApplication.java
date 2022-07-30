package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedica;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IGestorCitaMedica citaMedica;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Insertar 2 doctores
		Doctor doctor = new Doctor();
		doctor.setCedula("030555639");
		doctor.setNombre("Ruben");
		doctor.setApellido("Fueltala");
		doctor.setFechaNacimiento(LocalDateTime.of(1998, 12, 5, 9, 30));
		doctor.setNumeroConsultorio("AD-96");
		doctor.setCodigoSenescyt("sd84s");
		doctor.setGenero("M");

		this.doctorService.insertar(doctor);

		Doctor doctor2 = new Doctor();
		doctor2.setCedula("1789898585");
		doctor2.setNombre("Martha");
		doctor2.setApellido("Villa");
		doctor2.setFechaNacimiento(LocalDateTime.of(1979, 10, 6, 19, 3));
		doctor2.setNumeroConsultorio("PO-59");
		doctor2.setCodigoSenescyt("sd5f1ds");
		doctor2.setGenero("F");

		this.doctorService.insertar(doctor2);

		// Ingresar 2 pacientes
		Paciente paciente = new Paciente();
		paciente.setCedula("0263636325");
		paciente.setNombre("Pablo");
		paciente.setApellido("Ramirez");
		paciente.setFechaNacimiento(LocalDateTime.of(1986, 9, 7, 12, 0));
		paciente.setCodigoSeguro("A96DE");
		paciente.setEstatura(1.78);
		paciente.setPeso(55.6);
		paciente.setGenero("M");

		this.iPacienteService.insertar(paciente);

		Paciente paciente2 = new Paciente();
		paciente2.setCedula("9695325689");
		paciente2.setNombre("Paola");
		paciente2.setApellido("Arboleda");
		paciente2.setFechaNacimiento(LocalDateTime.of(1996, 1, 6, 6, 45));
		paciente2.setCodigoSeguro("ASD5");
		paciente2.setEstatura(1.59);
		paciente2.setPeso(70.4);
		paciente2.setGenero("F");

		this.iPacienteService.insertar(paciente2);

		this.citaMedica.agendamientoCitaMedica("6", LocalDateTime.now(), new BigDecimal("25.0"), "Hospital Voz Andes", "1789898585", "0263636325");
		
		List<PacienteSencillo> listaPaciente = this.citaMedica.reportePacientes(LocalDateTime.of(1900, 11, 9, 6, 12), "F");
		for(PacienteSencillo i : listaPaciente) {
			LOG.info("Persona " + i);
		}
		

	}

}
