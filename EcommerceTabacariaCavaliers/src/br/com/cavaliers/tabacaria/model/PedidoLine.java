package br.com.cavaliers.tabacaria.model;

public class PedidoLine 
{
	
	private int idPedidoLine;
	private int idPedidoHeader;
	private int idProduto;
	private int quantidadeProduto;
	private double valorProduto;
	private double precoUnitario;
	private String nomeDoProduto;
	
	public PedidoLine() 
	{
		
	}
	
	public PedidoLine( int idPedidoLine, int idPedidoHeader, int idProduto, int quantidadeProduto, double valorProduto, 
			String nomeDoProduto, double precoUnitario ) 
	{
		this.idPedidoHeader = idPedidoHeader;
		this.idPedidoLine =	idPedidoLine;	
		this.idProduto = idProduto;
		this.nomeDoProduto = nomeDoProduto;
		this.precoUnitario = precoUnitario;
		this.quantidadeProduto = quantidadeProduto; 
		this.valorProduto = valorProduto;
	}

	public int getIdPedidoLine() {
		return idPedidoLine;
	}

	public int getIdPedidoHeader() {
		return idPedidoHeader;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setIdPedidoLine(int idPedidoLine) {
		this.idPedidoLine = idPedidoLine;
	}

	public void setIdPedidoHeader(int idPedidoHeader) {
		this.idPedidoHeader = idPedidoHeader;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public void setQuantidaeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public String toString() {
		return "PedidoLine [idPedidoLine=" + idPedidoLine + ", idPedidoHeader=" + idPedidoHeader + ", idProduto="
				+ idProduto + ", quantidadeProduto=" + quantidadeProduto + ", valorProduto=" + valorProduto
				+ ", precoUnitario=" + precoUnitario + ", nomeDoProduto=" + nomeDoProduto + "]";
	}
	

}
