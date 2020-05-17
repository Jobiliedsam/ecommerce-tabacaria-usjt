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

public class ListarPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String chave = request.getParameter("data[search]");
		PedidoHeaderService phs = new PedidoHeaderService();
		ArrayList<PedidoHeader> lista = null;
		HttpSession session = request.getSession();

			if (chave != null && chave.length() > 0) {
				lista = phs.listarPedidoHeader(chave);
			} else {
				lista = phs.listarPedidoHeader();
			}
			session.setAttribute("listaPedidoHeader", lista);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPedidoHeader.jsp");
		dispatcher.forward(request, response);

	}

}
