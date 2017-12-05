package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	
	/*@ public invariant !titular.equals("");
	  @ public invariant !agencia.equals("");
	  @ public invariant !numero.equals("");
	  @ public invariant !banco.equals("");
	 @*/
	
	@GeneratedValue
	@Id
	private Integer id;
	
	private /*@ spec_public @*/ String titular;
	private /*@ spec_public @*/ String agencia;
	private /*@ spec_public @*/ String numero;
	private /*@ spec_public @*/ String banco;
	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
