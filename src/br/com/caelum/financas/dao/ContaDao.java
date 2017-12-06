package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao implements Dao<Conta>{

	private EntityManager manager;

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void adiciona(Conta conta) {
		manager.persist(conta);
	}

	@Override
	public Conta busca(Integer id) {
		return manager.find(Conta.class, id);
	}

	@Override
	public List<Conta> buscaTodos() {
		return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}

	@Override
	public void remove(Conta conta) {
		manager.remove(conta);
	}

	@Override
	public void atualiza(Conta entity) {
		// TODO Auto-generated method stub
		
	}

}
