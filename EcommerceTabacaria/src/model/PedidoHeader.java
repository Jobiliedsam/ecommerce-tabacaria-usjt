package model;

import java.util.Date;

public class PedidoHeader 
{
	
	private int idPedido;
	private int idCliente;
	private int qtdItens;
	private Date dataHoraCriacao;
	private double valorTotal;
	private String nomeCliente;
	
	public PedidoHeader () 
	{
		
	}

	public PedidoHeader(int idPedido, Date dataHoraCriacao, int idCliente, String nomeCliente, int qtdItens,
			double valorTotal) 
	{
		this.idPedido = idPedido;
		this.dataHoraCriacao = dataHoraCriacao;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.qtdItens = qtdItens;
		this.valorTotal = valorTotal;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Date dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
