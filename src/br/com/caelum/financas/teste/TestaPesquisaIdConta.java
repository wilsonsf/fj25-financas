package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIdConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = dao.busca(2);
		
		System.out.println(conta.getTitular());
		
		manager.close();
		
	}
}
