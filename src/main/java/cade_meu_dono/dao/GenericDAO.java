package cade_meu_dono.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.*;
import java.util.List;

public class GenericDAO<T, K> {

	protected EntityManager em;

	private Class<T> clazz;

	public GenericDAO(EntityManager em) {
		this.em = em;
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<T> theType = (Class<T>) type.getActualTypeArguments()[0];
		clazz = theType;
	}


	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public T find(K key) {
		return em.find(clazz, key);
	}

	public void delete(K key) throws Exception {
		T entity = find(key);
		if (entity == null) {
			throw new Exception("Entidade não encontrada.");
		}
		em.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			} else {
				throw new Exception("Erro ao modificar os dados.");
			}
		} finally {
			em.close();
		}
	}

}
