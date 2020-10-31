package model;

public class Produto {
	
	private int id;
	private String nome;
	private String ingredientes;
	private double preco;
	private String categoria;
	
	public Produto(int id, String nome, String ingredientes, double preco, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", ingredientes=" + ingredientes + ", preco=" + preco
				+ ", categoria=" + categoria + "]";
	}
	
	
	
	
}
