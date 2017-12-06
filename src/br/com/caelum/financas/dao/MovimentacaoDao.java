package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao implements Dao<Movimentacao> {

	//@ 
	
	private /*@ spec_public non_null @*/ EntityManager manager; //@in entityManager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void adiciona(Movimentacao movimentacao) {
		manager.persist(movimentacao);
	}

	@Override
	public Movimentacao busca(Integer id) {
		return manager.find(Movimentacao.class, id);
	}

	@Override
	public List<Movimentacao> buscaTodos() {
		return this.manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}

	@Override
	public void remove(Movimentacao mov) {
		manager.remove(mov);
	}

	@Override
	public void atualiza(Movimentacao mov) {
		// TODO Auto-generated method stub
		
	}

}
