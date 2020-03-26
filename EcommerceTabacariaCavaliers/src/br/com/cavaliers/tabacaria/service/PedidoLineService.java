package br.com.cavaliers.tabacaria.service;

import br.com.cavaliers.tabacaria.dao.PedidoLineDAO;
import br.com.cavaliers.tabacaria.model.PedidoLine;

public class PedidoLineService 
{
	PedidoLineDAO dao = new PedidoLineDAO();

	public int criar(PedidoLine pedidoLine) {
		return dao.inserir(pedidoLine);
	}

	public void atualizar(PedidoLine pedidoLine) {
		dao.atualizar(pedidoLine);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public PedidoLine carregar(int id) {
		return dao.carregar(id);
	}
}
