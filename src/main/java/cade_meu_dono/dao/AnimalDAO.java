package cade_meu_dono.dao;

import javax.persistence.EntityManager;

import cade_meu_dono.entity.Animal;

public class AnimalDAO extends GenericDAO<Animal, Long> {
	
	public AnimalDAO(EntityManager em) {
		super(em);
	}
	
	public static void commit(AnimalDAO uDAO) {
		try {
			uDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
