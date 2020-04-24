package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.PedidoHeader;
import br.com.cavaliers.tabacaria.service.PedidoHeaderService;

public class EditarPedidoHeader implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("idPedido");
		String pNomeCliente = request.getParameter("nomeCliente");
		int pQtdItens = Integer.parseInt(request.getParameter("qtdItens"));
		double pValorTotal = Double.parseDouble(request.getParameter("valorTotal"));
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e){
			
		}
		PedidoHeader pedidoHeader = new PedidoHeader();
		PedidoHeaderService phs = new PedidoHeaderService();
		RequestDispatcher view = null;
		
		pedidoHeader.setIdPedido(id);
		pedidoHeader.setNomeCliente(pNomeCliente);
		pedidoHeader.setQtdItens(pQtdItens);
		pedidoHeader.setValorTotal(pValorTotal);
		
		
		pedidoHeader  = phs.carregar(pedidoHeader.getIdPedido());
		request.setAttribute("pedidoHeader", pedidoHeader);
		view = request.getRequestDispatcher("AlterarPedidoHeader.jsp");
		view.forward(request, response);
	}

}
