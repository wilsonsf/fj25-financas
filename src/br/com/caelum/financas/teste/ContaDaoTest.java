package br.com.caelum.financas.teste;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class ContaDaoTest {

	private static ContaDao dao;
	private static EntityManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = JPAUtil.getEntityManager();
		populaTabela();
	}

	private static void populaTabela() {
		dao = new ContaDao(manager);
		manager.getTransaction().begin();
		for (int i = 0; i < 9; i++) {
			Conta c = criaConta(i);
			dao.adiciona(c);
		}
		manager.getTransaction().commit();
		manager.close();
	}
	
	private static Conta criaConta(Integer it) {
		String diff = (it == null ? "" : it.toString());
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto"+diff);
		conta.setBanco("Banco do Brasil"+diff);
		conta.setNumero(diff+"123456-6");
		conta.setAgencia(diff+"0999");
		return conta;
	}

	private Conta criaConta() {
		return criaConta(null);
	}
	
	@Before
	public void setUp() throws Exception {
		manager = JPAUtil.getEntityManager();
		dao = new ContaDao(manager);
	}
	
	@After
	public void tearDown() throws Exception {
		manager.close();
	}

	@Test
	public void deveInserirUmaConta() {
		
		Conta conta = criaConta();
		
		Integer contagem = dao.buscaTodos().size();
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();
		
		assertTrue(conta.getId() != null);
		assertTrue(dao.buscaTodos().size() == contagem + 1);
	}
	
	@Test
	public void deveRemoverUmaConta() {

		Conta conta = criaConta();
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();
		
		Integer contagem = dao.buscaTodos().size();
		
		manager.getTransaction().begin();
		dao.remove(conta);
		manager.getTransaction().commit();
		
		assertTrue(dao.buscaTodos().size() == contagem - 1);
	}
	
	@Test
	public void deveBuscarUmaConta() {
		Conta encontrado = dao.busca(3);
		
		assertTrue(encontrado != null);
		assertTrue(encontrado.getId() != null);
	}
	
	@Test
	public void deveBuscarTodosOsRegistros() {
		List<Conta> lista = dao.buscaTodos();
		
		assertTrue(lista != null);
		assertTrue(lista.size() > 0);
	}
	

}
