package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		long fim = System.currentTimeMillis();
		System.out.println("Conta gravada com sucesso! / Executado em: "+ (fim-inicio) + " ms");
	}
}
