package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPacienteRepo;
import com.uce.edu.demo.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo iPacienteRepo;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepo.insertar(paciente);
	}

	@Override
	public Paciente buscar(Integer codigo) {
		// TODO Auto-generated method stub
		return this.iPacienteRepo.buscar(codigo);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepo.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer codigo) {
		// TODO Auto-generated method stub
		this.iPacienteRepo.eliminar(codigo);
	}

}
