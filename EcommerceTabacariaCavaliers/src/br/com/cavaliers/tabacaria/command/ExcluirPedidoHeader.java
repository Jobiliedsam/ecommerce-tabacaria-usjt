package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.PedidoHeader;
import br.com.cavaliers.tabacaria.service.PedidoHeaderService;

public class ExcluirPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		PedidoHeader pedidoHeader = new PedidoHeader();
		pedidoHeader.setIdPedido(id);
		
		PedidoHeaderService phs = new PedidoHeaderService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		phs.excluir(pedidoHeader.getIdPedido());
		ArrayList<PedidoHeader> lista = (ArrayList<PedidoHeader>) session.getAttribute("listaPedidoHeader");
		lista.remove(busca(pedidoHeader, lista));
		session.setAttribute("listaPedidoHeader", lista);
		view = request.getRequestDispatcher("ListarPedidoHeaderTeste.jsp");
		
		view.forward(request, response);

	}

	public int busca(PedidoHeader pedidoHeader, ArrayList<PedidoHeader> lista) {
		PedidoHeader to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdPedido() == pedidoHeader.getIdPedido()) {
				return i;
			}
		}
		return -1;
	}

}
