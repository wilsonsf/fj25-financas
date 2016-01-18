package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {

	private EntityManager manager;

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Conta conta) {
		manager.persist(conta);
	}

	public Conta busca(Integer i) {
		return manager.find(Conta.class, i);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}

	public void remove(Conta conta) {
		manager.remove(conta);
	}

}
