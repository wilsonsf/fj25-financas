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
	private /*@ spec_public @*/ Integer id;
	
	private /*@ spec_public non_null @*/ String titular;
	private /*@ spec_public non_null @*/ String agencia;
	private /*@ spec_public non_null @*/ String numero;
	private /*@ spec_public non_null @*/ String banco;
	
	/*@	requires newTitular != null && !newTitular.equals("");
	  @ requires newAgencia != null && !newAgencia.equals("");
	  @	requires newNumero != null && !newNumero.equals("");
	  @	requires newBanco != null && !newBanco.equals("");
	  @ assignable titular;
	  @ assignable agencia;
	  @ assignable numero;
	  @ assignable banco;
	  @ ensures titular.equals(newTitular);
	  @ ensures agencia.equals(newAgencia);
	  @ ensures numero.equals(newNumero);
	  @ ensures banco.equals(newBanco);	@*/
	public Conta(String newTitular, String newAgencia, String newNumero, String newBanco) {
		this.titular = newTitular;
		this.agencia = newAgencia;
		this.numero = newNumero;
		this.banco = newBanco;
	}
	
	/*@	requires newId != null && !newId.equals("");
	  @ assignable id;
	  @ ensures id.equals(newId);	@*/
	public Conta(Integer newId) {
		this.id = newId;
	}
	@Deprecated
	public /*@ pure @*/ Conta() {	}
	
	/*@	assignable \nothing;
	  @	ensures \result == this.titular; 
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public /*@ pure @*/ String getTitular() {
		return titular;
	}

	/*@ requires newTitular != null && !newTitular.equals("");
	  @ assignable titular;
	  @ ensures titular.equals(newTitular);
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public void setTitular(String newTitular) {
		this.titular = newTitular;
	}

	/*@	assignable \nothing;
	  @	ensures \result == this.agencia;
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public /*@ pure @*/ String getAgencia() {
		return agencia;
	}

	/*@ requires newAgencia != null && !newAgencia.equals("");
	  @ assignable agencia;
	  @ ensures agencia.equals(newAgencia);
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public void setAgencia(String newAgencia) {
		this.agencia = newAgencia;
	}
	
	/*@	assignable \nothing;
	  @	ensures \result == this.numero;
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public /*@ pure @*/ String getNumero() {
		return numero;
	}

	/*@ requires newNumero != null && !newNumero.equals("");
	  @ assignable numero;
	  @ ensures numero.equals(newNumero);
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& banco == \old(banco);
	  @ @*/
	public void setNumero(String newNumero) {
		this.numero = newNumero;
	}

	/*@	assignable \nothing;
	  @	ensures \result == this.banco;
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public /*@ pure @*/ String getBanco() {
		return banco;
	}

	/*@ requires newBanco != null && !newBanco.equals("");
	  @ assignable banco;
	  @ ensures banco.equals(newBanco);
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero);
	  @ @*/
	public void setBanco(String newBanco) {
		this.banco = newBanco;
	}

	/*@	assignable \nothing;
	  @	ensures \result == this.id;
	  @ ensures_redundantly
	  @		id == \old(id)
	  @		&& titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public /*@ pure @*/ Integer getId() {
		return id;
	}

	/*@ requires newId != null && !newId.equals("");
	  @ assignable id;
	  @ ensures id.equals(newId);	
	  @ ensures_redundantly
	  @		titular == \old(titular)
	  @		&& agencia == \old(agencia)
	  @		&& numero == \old(numero)
	  @		&& banco == \old(banco);
	  @ @*/
	public void setId(Integer newId) {
		this.id = newId;
	}
	
	// @ param args
	public static void main(String[] args) {
		setTitularTest();
	}

	private static void setTitularTest() {
		String novoTitular = "5";
		//@ assert novoTitular != null && novoTitular.equals("");
		Conta conta = new Conta();
		conta.setTitular(novoTitular);
		//@	assume conta.getTitular.equals(novoTitular);
	}

}
