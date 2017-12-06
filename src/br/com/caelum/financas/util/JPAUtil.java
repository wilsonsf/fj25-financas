package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static /*@ spec_public @*/ EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
	
	public /*@ pure @*/ static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
