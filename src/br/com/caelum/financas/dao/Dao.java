package br.com.caelum.financas.dao;

import java.util.List;

public interface Dao<E> {
	//@ model instance Integer id;
	void adiciona(E entity);
	E busca(Integer id);
	List<E> buscaTodos();
	void remove(E entity);
	void atualiza(E entity);
}
