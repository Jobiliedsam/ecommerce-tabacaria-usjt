package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.PedidoLine;
import br.com.cavaliers.tabacaria.service.PedidoLineService;

public class EditarPedidoLine implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId = request.getParameter("idPedidoLine");
		int pIdPedidoHeader = Integer.parseInt(request.getParameter("idPedidoHeader"));
		int pIdProduto = Integer.parseInt(request.getParameter("idProduto"));
		int pQuantidadeProduto = Integer.parseInt(request.getParameter("quantidadeProduto"));
		double pValorProduto = Double.parseDouble(request.getParameter("valorProduto"));
		String pNomeDoProduto = request.getParameter("nomeDoProduto");
		double pPrecoUnitario = Integer.parseInt(request.getParameter("precoUnitario"));
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e) {
			
		}
		
		PedidoLine pedidoLine = new PedidoLine();
		pedidoLine.setIdPedidoLine(id);
		pedidoLine.setIdPedidoHeader(pIdPedidoHeader);
		pedidoLine.setIdProduto(pIdProduto);
		pedidoLine.setQuantidaeProduto(pQuantidadeProduto);
		pedidoLine.setValorProduto(pValorProduto);
		pedidoLine.setNomeDoProduto(pNomeDoProduto);
		pedidoLine.setPrecoUnitario(pPrecoUnitario);
		
		PedidoLineService pls = new PedidoLineService();
		RequestDispatcher view = null;
		
		pedidoLine = pls.carregar(pedidoLine.getIdPedidoLine());
		request.setAttribute("pedidoLine", pedidoLine);
		view = request.getRequestDispatcher("AlterarPedidoLine.jsp");
		view.forward(request, response);
	}

}
