package br.com.cavaliers.tabacaria.service;

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

	public void excluir(int id) {
		dao.excluir(id);
	}

	public PedidoHeader carregar(int id) {
		return dao.carregar(id);
	}
}
