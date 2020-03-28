package br.com.cavaliers.tabacaria.model;

public class PedidoLine 
{
	
	private int idPedioLine;
	private int idPedidoHeader;
	private int idProduto;
	private int quantidaeProduto;
	private double valorProduto;
	private double precoUnitario;
	private String nomeDoProduto;
	
	public PedidoLine() 
	{
		
	}
	
	public PedidoLine( int idPedioLine, int idPedidoHeader, int idProduto, int quantidaeProduto, double valorProduto, 
			String nomeDoProduto, double precoUnitario ) 
	{
		this.idPedidoHeader = idPedidoHeader;
		this.idPedioLine =	idPedioLine;	
		this.idProduto = idProduto;
		this.nomeDoProduto = nomeDoProduto;
		this.precoUnitario = precoUnitario;
		this.quantidaeProduto = quantidaeProduto; 
		this.valorProduto = valorProduto;
	}

	public int getIdPedioLine() {
		return idPedioLine;
	}

	public int getIdPedidoHeader() {
		return idPedidoHeader;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public int getQuantidaeProduto() {
		return quantidaeProduto;
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

	public void setIdPedioLine(int idPedioLine) {
		this.idPedioLine = idPedioLine;
	}

	public void setIdPedidoHeader(int idPedidoHeader) {
		this.idPedidoHeader = idPedidoHeader;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public void setQuantidaeProduto(int quantidaeProduto) {
		this.quantidaeProduto = quantidaeProduto;
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
		return "PedidoLine [idPedioLine=" + idPedioLine + ", idPedidoHeader=" + idPedidoHeader + ", idProduto="
				+ idProduto + ", quantidaeProduto=" + quantidaeProduto + ", valorProduto=" + valorProduto
				+ ", precoUnitario=" + precoUnitario + ", nomeDoProduto=" + nomeDoProduto + "]";
	}
	

}
