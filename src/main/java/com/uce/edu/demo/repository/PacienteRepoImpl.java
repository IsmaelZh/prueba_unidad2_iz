package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
		
		LOG.info("Se inserto el paciente: " + paciente);
	}

	@Override
	public Paciente buscar(Integer codigo) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, codigo);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer codigo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(codigo));
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula", Paciente.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> reportePacientes(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :datoFecha AND p.genero =:datoGenero",
				PacienteSencillo.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
		
		

	}

}
