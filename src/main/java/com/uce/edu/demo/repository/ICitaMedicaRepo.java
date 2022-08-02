package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	public void insertar(CitaMedica cita);
	
	public void actualizar(CitaMedica cita);
	
	public CitaMedica buscarPorNumero(String numero);

}
