package service;

import model.PedidoLine;
import dao.PedidoLineDAO;

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
