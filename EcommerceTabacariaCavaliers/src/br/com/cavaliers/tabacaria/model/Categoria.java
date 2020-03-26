package br.com.cavaliers.tabacaria.model;

public class Categoria {
	
	private int idCategoria;
	private String categoria;
	private String status;
	private String descricao;
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria, String categoria, String status, String descricao ) 
	{
		this.categoria = categoria;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
		this.status = status;
		
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getStatus() {
		return status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
