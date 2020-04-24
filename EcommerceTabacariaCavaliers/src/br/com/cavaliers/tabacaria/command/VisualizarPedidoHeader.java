package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.PedidoHeader;
import br.com.cavaliers.tabacaria.service.PedidoHeaderService;

public class VisualizarPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId = request.getParameter("idPedido");
		String pNomeCliente = request.getParameter("nomeCliente");
		int pQtdItens = Integer.parseInt(request.getParameter("status"));
		double pValorTotal = Double.parseDouble(request.getParameter("valorTotal"));
		int id = -1;

		try 
		{
			id = Integer.parseInt(pId);
		} 
		catch (NumberFormatException e)
		{

		}

		PedidoHeader pedidoHeader = new PedidoHeader();
		PedidoHeaderService phs = new PedidoHeaderService();

		pedidoHeader.setNomeCliente(pNomeCliente);
		pedidoHeader.setQtdItens(pQtdItens);
		pedidoHeader.setValorTotal(pValorTotal);
		pedidoHeader.setIdPedido(phs.criar(pedidoHeader));

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		pedidoHeader = phs.carregar(pedidoHeader.getIdPedido());
		request.setAttribute("pedidoHeader", pedidoHeader);
		view = request.getRequestDispatcher("VisualizarPedidoHeader.jsp");
		
		view.forward(request, response);
	}

}
