package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.PedidoLine;
import br.com.cavaliers.tabacaria.service.PedidoLineService;

public class AlterarPedidoLine implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		HttpSession session = request.getSession();
		
		pls.atualizar(pedidoLine);
		ArrayList<PedidoLine> lista = (ArrayList<PedidoLine>)session.getAttribute("lista");
		int pos = busca(pedidoLine, lista);
		lista.remove(pos);
		lista.add(pos,pedidoLine);
		session.setAttribute("lista", lista);
		request.setAttribute("pedidoLine", pedidoLine);
		view = request.getRequestDispatcher("VisualizarPedidoLine.jsp");

		view.forward(request, response);
	}
		public int busca(PedidoLine pedidoLine, ArrayList<PedidoLine> lista) {
			PedidoLine to;
			for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getIdPedidoLine() == pedidoLine.getIdPedidoLine()){
					return i;
				}
			}
			return -1;
	}

}
