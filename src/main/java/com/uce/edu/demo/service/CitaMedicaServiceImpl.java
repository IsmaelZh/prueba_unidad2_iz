package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepo;
import com.uce.edu.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;

	@Override
	public void insertar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.insertar(cita);
	}

}
