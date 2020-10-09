package model;

public class Pedido {
	
	int id;
	int idUser;
	String nome;
	double preco;
	
	
	public Pedido(int id, int idUser, String nome, double preco) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nome = nome;
		this.preco = preco;
		
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idUser=" + idUser + ", nome=" + nome + ", preco=" + preco +  "]";
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}

