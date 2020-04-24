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

public class CriarPedidoLine implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNomeDoProduto = request.getParameter("nomeDoProduto");
		int pQuantidadeProduto = Integer.parseInt(request.getParameter("quantidadeProduto"));
		double pValorProduto = Double.parseDouble(request.getParameter("valorProduto"));
		int pPrecounitario = Integer.parseInt(request.getParameter("contatoTelefone"));
		
		PedidoLine pedidoLine = new PedidoLine();
		pedidoLine.setNomeDoProduto(pNomeDoProduto);
		pedidoLine.setQuantidaeProduto(pQuantidadeProduto);
		pedidoLine.setValorProduto(pValorProduto);
		pedidoLine.setPrecoUnitario(pPrecounitario);
		
		
		PedidoLineService pls = new PedidoLineService();
		pls.criar(pedidoLine);

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		ArrayList<PedidoLine> lista = new ArrayList<>();
		lista.add(pedidoLine);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPedidoLine.jsp");
		
		view.forward(request, response);
		
	}

}
