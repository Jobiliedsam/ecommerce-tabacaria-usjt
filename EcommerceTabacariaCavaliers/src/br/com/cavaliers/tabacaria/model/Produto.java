package br.com.cavaliers.tabacaria.model;

public class Produto {

	private int idProduto;
	private double precoF;
	private String nomeP;
	private String categoria;
	private String fornecedor;
	private String status;
	private String descricao;
	private int quantidade;

	public Produto() {

	}

	public Produto(int idProduto, String nomeP, String categoria, double precoF, String fornecedor, String status,
			String descricao, int quntidade) {
		this.idProduto = idProduto;
		this.nomeP = nomeP;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.precoF = precoF;
		this.status = status;
		this.descricao = descricao;
		this.quantidade = quantidade;
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

	public void setPrecoF(double pPreco) {
		this.precoF = pPreco;
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

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", precoF=" + precoF + ", nomeP=" + nomeP + ", categoria="
				+ categoria + ", fornecedor=" + fornecedor + ", status=" + status + ", descricao=" + descricao + "]";
	}

}
