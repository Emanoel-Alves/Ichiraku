package model;

public class Pedido {
	
	int id;
	int idUser;
	String nome;
	double valorTotal;
	
	
	public Pedido(int id, int idUser, String nome, double preco) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nome = nome;
		this.valorTotal = preco;
		
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idUser=" + idUser + ", nome=" + nome + ", valorTotal=" + valorTotal +  "]";
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

	public void setValorTotal(double preco) {
		this.valorTotal = preco;
	}

}

