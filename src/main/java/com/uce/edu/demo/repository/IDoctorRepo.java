package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepo {

	public void insertar (Doctor doctor);
	public Doctor buscar (Integer codigo);
	public void actualizar (Doctor doctor);
	public void eliminar (Integer codigo);
	
	public Doctor buscarPorCedula(String cedula);
	
}
