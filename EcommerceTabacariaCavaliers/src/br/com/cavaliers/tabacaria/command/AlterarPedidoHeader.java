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

public class AlterarPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int pQtdItens = Integer.parseInt(request.getParameter("qtdItens"));
		double pValorTotal = Double.parseDouble(request.getParameter("valorTotal"));
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e){
			// TODO: handle exception
		}
		PedidoHeader pedidoHeader = new PedidoHeader();
		PedidoHeaderService phs = new PedidoHeaderService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		pedidoHeader.setIdPedido(id);
		pedidoHeader.setQtdItens(pQtdItens);
		pedidoHeader.setValorTotal(pValorTotal);
		phs.atualizar(pedidoHeader);
		
		ArrayList<PedidoHeader> lista = (ArrayList<PedidoHeader>) session.getAttribute("lista");
		int pos = buscar(pedidoHeader, lista);
		lista.remove(pos);
		lista.add(pos, pedidoHeader);
		session.setAttribute("lista", lista);
		request.setAttribute("pedidoHeader", pedidoHeader);
		view = request.getRequestDispatcher("VisualizarPedidoHeader.jsp");
		
		view.forward(request, response);

	}
	public int buscar(PedidoHeader pedidoHeader, ArrayList<PedidoHeader> lista) {
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
