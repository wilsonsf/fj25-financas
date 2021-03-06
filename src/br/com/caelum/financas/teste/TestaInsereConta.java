package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		manager.getTransaction().begin();
		
		dao.adiciona(conta);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
