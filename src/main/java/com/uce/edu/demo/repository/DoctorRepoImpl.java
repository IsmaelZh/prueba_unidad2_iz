package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;
@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
		
		LOG.info("Se inserto el doctor: " + doctor);
	}

	@Override
	public Doctor buscar(Integer codigo) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, codigo);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(Integer codigo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(codigo));
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Doctor> myTypedQuery = this.entityManager
				.createQuery("SELECT d FROM Doctor d WHERE d.cedula = :datoCedula", Doctor.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

}
