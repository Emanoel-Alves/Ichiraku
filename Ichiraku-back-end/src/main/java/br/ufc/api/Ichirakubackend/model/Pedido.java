package br.ufc.api.Ichirakubackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue
	int id;
	int idUser;
	String nome;
	double valorTotal;
	
	public Pedido() {
		super();
		
	}

	public Pedido(int id, int idUser, String nome, double valorTotal) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nome = nome;
		this.valorTotal = valorTotal;
	}
	
	public Pedido( int idUser, String nome, double valorTotal) {
		super();
		this.idUser = idUser;
		this.nome = nome;
		this.valorTotal = valorTotal;
	}
	
	

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idUser=" + idUser + ", nome=" + nome + ", valorTotal=" + valorTotal + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
