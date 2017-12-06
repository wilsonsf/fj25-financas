package br.ufrn.logica;

import br.com.caelum.financas.modelo.Conta;


public class Main {

	/*
	 * @param args
	 */
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		// Invariant - Test 1 - Quebra
		//conta.setTitular("");
		// Invariant - Test 1 - Funcionando
		//conta.setTitular("Fulano");
		
		//  - Test  - Quebra
		conta.setAgencia("-3");
		//  - Test  - Funcionando
		//conta.setAgencia(1234);
		
		System.out.println("Done.");
		
	}

}
