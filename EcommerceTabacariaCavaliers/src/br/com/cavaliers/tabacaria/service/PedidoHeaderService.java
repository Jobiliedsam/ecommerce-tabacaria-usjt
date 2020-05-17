package br.com.cavaliers.tabacaria.service;

import java.util.ArrayList;

import br.com.cavaliers.tabacaria.dao.PedidoHeaderDAO;
import br.com.cavaliers.tabacaria.model.PedidoHeader;

public class PedidoHeaderService 
{
	PedidoHeaderDAO dao = new PedidoHeaderDAO();

	public int criar(PedidoHeader pedidoHeader) {
		return dao.inserir(pedidoHeader);
	}

	public void atualizar(PedidoHeader pedidoHeader) {
		dao.atualizar(pedidoHeader);
	}
	public PedidoHeader carregar(int idPedido){
		return dao.carregar(idPedido);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public ArrayList<PedidoHeader> listarPedidoHeader(){
		return dao.listarPedidoHeader();
	}
	public ArrayList<PedidoHeader> listarPedidoHeader(String chave){
		return dao.listarPedidoHeader(chave);
	}
}
