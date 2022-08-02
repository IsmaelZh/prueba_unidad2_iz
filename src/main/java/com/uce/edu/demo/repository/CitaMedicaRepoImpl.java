package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cita);

		LOG.info("Se inserto la cita: " + cita);
	}

	@Override
	public void actualizar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cita);
	}

	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> miQuery = this.entityManager
				.createQuery("SELECT c from CitaMedica c Where c.numeroCita = :datoNumero", CitaMedica.class);
		miQuery.setParameter("datoNumero", numero);
		return miQuery.getSingleResult();
	}

}
