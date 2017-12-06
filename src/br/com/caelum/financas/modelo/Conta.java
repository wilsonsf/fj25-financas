package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	
	/*@ public invariant !titular.equals("");
	  @ public invariant !agencia.equals("");
	  @ public invariant !numero.equals("");
	  @ public invariant !banco.equals("");	@*/
	
	@GeneratedValue
	@Id
	private /*@ spec_public nullable @*/ Integer id;
	
	private /*@ spec_public @*/ String titular;
	private /*@ spec_public @*/ String agencia;
	private /*@ spec_public @*/ String numero;
	private /*@ spec_public @*/ String banco;
	
	@Deprecated
	public Conta() {	}
	
	public /*@ pure @*/ String getTitular() {
		return titular;
	}

	/*@ requires t != null && t.equals("");
	  @ assignable titular;
	  @ ensures titular.equals(t);	@*/
	public void setTitular(String t) {
		this.titular = t;
	}

	public /*@ pure @*/ String getAgencia() {
		return agencia;
	}

	/*@ requires a != null && a.equals("");
	  @ assignable agencia;
	  @ ensures agencia.equals(a);	@*/
	public void setAgencia(String a) {
		this.agencia = a;
	}

	public /*@ pure @*/ String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public /*@ pure @*/ String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public /*@ pure @*/ Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		
	}

}
