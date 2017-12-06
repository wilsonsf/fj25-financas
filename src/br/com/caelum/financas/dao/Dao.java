package br.com.caelum.financas.dao;

import java.util.List;

public interface Dao<E> {
	//@ model instance EntityManager entityManager;
	
	//@ ensures entity.getId() != 0;
	void adiciona(E entity);
	
	//@ requires id > 0;
	E busca(/*@ non_null @*/ Integer id);
	List<E> buscaTodos();
	void remove(E entity);
	void atualiza(E entity);
}
