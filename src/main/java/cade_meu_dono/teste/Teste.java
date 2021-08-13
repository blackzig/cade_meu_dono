package cade_meu_dono.teste;

import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		System.out.println("START");
		Persistence.createEntityManagerFactory("cade_meu_dono").createEntityManager();

	}

}
