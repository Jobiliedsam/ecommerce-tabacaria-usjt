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

public class CriarPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNomeCliente = request.getParameter("nomeCliente");
		int pQtdItens = Integer.parseInt(request.getParameter("qtdItens"));
		double pValorTotal = Double.parseDouble(request.getParameter("valorTotal"));
		
		PedidoHeader pedidoHeader = new PedidoHeader();
		PedidoHeaderService phs = new PedidoHeaderService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		pedidoHeader.setNomeCliente(pNomeCliente);
		pedidoHeader.setQtdItens(pQtdItens);
		pedidoHeader.setValorTotal(pValorTotal);
		phs.criar(pedidoHeader);
		
		ArrayList<PedidoHeader> lista = new ArrayList<>();
		lista.add(pedidoHeader);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPedidoHeader.jsp");
		
		view.forward(request, response);
	}

}
