package cade_meu_dono.dao;

import javax.persistence.EntityManager;

import cade_meu_dono.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Long> {

	public UsuarioDAO(EntityManager em) {
		super(em);
	}
	
	public static void commit(UsuarioDAO uDAO) {
		try {
			uDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
