package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepo;
import com.uce.edu.demo.repository.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo iDoctorRepo;

	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepo.insertar(doctor);
	}

	@Override
	public Doctor buscar(Integer codigo) {
		// TODO Auto-generated method stub
		return this.iDoctorRepo.buscar(codigo);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepo.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer codigo) {
		// TODO Auto-generated method stub
		this.iDoctorRepo.eliminar(codigo);
	}

}
