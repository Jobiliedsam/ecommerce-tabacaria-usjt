package service;

import model.PedidoHeader;
import dao.PedidoHeaderDAO;

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
