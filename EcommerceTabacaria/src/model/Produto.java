package model;

public class Produto 
{
	
	private int idProduto;
	private double precoF;
	private String nomeP;
	private String categoria;
	private String status;
	private String descricao;
	
	public Produto () 
	{
		
	}

	public Produto(int idProduto, String nomeP, String categoria, double precoF, String status, String descricao) 
	{
		this.idProduto = idProduto;
		this.nomeP = nomeP;
		this.categoria = categoria;
		this.precoF = precoF;
		this.status = status;
		this.descricao = descricao;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeP() {
		return nomeP;
	}

	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecoF() {
		return precoF;
	}

	public void setPrecoF(double precoF) {
		this.precoF = precoF;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
