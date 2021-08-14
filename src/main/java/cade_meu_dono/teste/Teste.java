package cade_meu_dono.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cade_meu_dono.dao.AnimalDAO;
import cade_meu_dono.dao.UsuarioDAO;
import cade_meu_dono.entity.Animal;
import cade_meu_dono.entity.Status;
import cade_meu_dono.entity.Usuario;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("cade_meu_dono").createEntityManager();
		opcoesUsuario(em, 6);
		// opcoesAnimal(em, 6);
	}

	public static void opcoesAnimal(EntityManager em, Integer acao) {
		AnimalDAO uDAO = new AnimalDAO(em);
		Long key = 1L;
		switch (acao) {
		case 1:
			salvarAnimal(uDAO);
			break;
		case 2:
			encontrar(uDAO, key);
			break;
		case 3:
			listar(uDAO);
			break;
		case 4:
			atualizar(uDAO, key);
			break;
		case 5:
			remover(uDAO, key);
			break;
		case 6:
			animalEhDe(uDAO, key, em);
			break;
		default:
			break;
		}
	}

	public static void opcoesUsuario(EntityManager em, Integer acao) {
		UsuarioDAO uDAO = new UsuarioDAO(em);
		Long key = 1L;
		switch (acao) {
		case 1:
			salvarUsuario(uDAO);
			break;
		case 2:
			encontrar(uDAO, key);
			break;
		case 3:
			listar(uDAO);
			break;
		case 4:
			atualizar(uDAO, key);
			break;
		case 5:
			remover(uDAO, key);
			break;
		case 6:
			donoTem(uDAO, key, em);
			break;
		default:
			break;
		}
	}

	public static void listar(UsuarioDAO uDAO) {
		List<Usuario> lista = uDAO.findAll();
		for (Usuario us : lista) {
			System.out.println(us.getId() + " " + us.getNome());
		}
	}

	public static Usuario encontrar(UsuarioDAO uDAO, Long key) {
		Usuario usuario = uDAO.find(key);
		return usuario;
	}

	public static void remover(UsuarioDAO uDAO, Long key) {
		try {
			uDAO.delete(key);
			UsuarioDAO.commit(uDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void atualizar(UsuarioDAO uDAO, Long key) {
		Usuario u = encontrar(uDAO, key);
		u.setSenha("1234");
		u.setLatitude("1");
		u.setLongitude("2");
		uDAO.update(u);
		UsuarioDAO.commit(uDAO);
	}

	public static void salvarUsuario(UsuarioDAO uDAO) {
		Usuario u = new Usuario();
		u.setNome("Michel Adriano Medeiros");
		u.setSenha("123");
		u.setTelefone("(19)991923566");
		u.setCidade("Rio Claro");
		u.setEstado("SP");
		uDAO.save(u);
		UsuarioDAO.commit(uDAO);
	}

	public static void donoTem(UsuarioDAO uDAO, Long key, EntityManager em) {
		AnimalDAO aniDAO = new AnimalDAO(em);
		Animal an = encontrar(aniDAO, 2L);
		List<Animal> lista = new ArrayList<>();
		lista.add(an);

		Usuario u = encontrar(uDAO, 1L);
		u.setAnimais(lista);
		uDAO.update(u);
		UsuarioDAO.commit(uDAO);
	}

	/********************** ANIMAL ***********************/

	public static void salvarAnimal(AnimalDAO uDAO) {
		Animal u = new Animal();
		u.setNome("PET1");
		u.setGenero("M");
		u.setStatus(Status.VIVO);
		uDAO.save(u);
		AnimalDAO.commit(uDAO);
	}

	public static Animal encontrar(AnimalDAO uDAO, Long key) {
		Animal animal = uDAO.find(key);
		return animal;
	}

	public static void listar(AnimalDAO uDAO) {
		List<Animal> lista = uDAO.findAll();
		for (Animal us : lista) {
			System.out.println(us.getId() + " " + us.getNome());
		}
	}

	public static void atualizar(AnimalDAO uDAO, Long key) {
		Animal u = encontrar(uDAO, key);
		u.setNome("Peludinho");
		uDAO.update(u);
		AnimalDAO.commit(uDAO);
	}

	public static void remover(AnimalDAO uDAO, Long key) {
		try {
			uDAO.delete(key);
			AnimalDAO.commit(uDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void animalEhDe(AnimalDAO uDAO, Long key, EntityManager em) {
		// Quem tem a anotação mappedBy não funciona para gravar na tabela de
		// associação.
		UsuarioDAO usuDAO = new UsuarioDAO(em);
		Usuario us = encontrar(usuDAO, 1L);
		List<Usuario> lista = new ArrayList<>();
		lista.add(us);

		Animal u = encontrar(uDAO, key);
		u.setUsuarios(lista);
		uDAO.update(u);
		AnimalDAO.commit(uDAO);
	}

	/*
	 * Given that you use MariaDB, you need to use (depending on the version of
	 * MariaDB and - maybe - the version of Hibernate) one of:
	 * 
	 * org.hibernate.dialect.MariaDBDialect -----------------------------------
	 * org.hibernate.dialect.MariaDB53Dialect
	 * 
	 * If you are using MySQL, or if the above two dialects for MariaDB don't exist
	 * in your version of Hibernate:
	 * 
	 * org.hibernate.dialect.MySQL5Dialect -----------------------------------
	 * org.hibernate.dialect.MySQL55Dialect -----------------------------------
	 * org.hibernate.dialect.MySQL57Dialect
	 * 
	 */

}
