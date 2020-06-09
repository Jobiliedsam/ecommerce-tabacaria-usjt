package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.PedidoHeader;
import br.com.cavaliers.tabacaria.model.PedidoLine;
import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.service.ProdutoService;
import br.com.cavaliers.tabacaria.service.PedidoHeaderService;
import br.com.cavaliers.tabacaria.service.PedidoLineService;

public class CriarPedidoHeader implements Command 
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.print("Estou aqui2");
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		Cliente cliente = (Cliente)session.getAttribute("currentUser");
		ArrayList<PedidoLine> pedidoLines = (ArrayList<PedidoLine>)session.getAttribute("produtosCarrinho");
		PedidoHeader pedidoHeader = (PedidoHeader)session.getAttribute("orderHeader");
		
		
		PedidoHeaderService phs = new PedidoHeaderService();
		PedidoLineService pls = new PedidoLineService();
		ProdutoService ps = new ProdutoService();
		
		if (pedidoHeader.getNomeCliente() == null || pedidoHeader.getIdCliente() == 0)
		{
			pedidoHeader.setNomeCliente(cliente.getNomeCompleto());
			pedidoHeader.setIdCliente(cliente.getIdCliente());
		}
		
		pedidoHeader.setIdPedido(phs.criar(pedidoHeader));
		
		//for (PedidoLine linha : pedidoLines)
		//{
			//linha.setIdPedidoHeader(pedidoHeader.getIdPedido());
			//pls.criar(linha);
			
		//	Produto produtoCart = produtosCart.get(linha.)
			
			//int newQtd = linha.getQuantidadeProduto();.
			
		//}
		
		for (int i = 0; i < pedidoLines.size(); i++)
		{
			PedidoLine linha = pedidoLines.get(i);
			linha.setIdPedidoHeader(pedidoHeader.getIdPedido());
			pls.criar(linha);
			
			Produto produtoCart = ps.carregar(linha.getIdProduto());
			
			int newQtd = linha.getQuantidadeProduto() - produtoCart.getQuantidade();
			
			System.out.println(newQtd);
			
			ps.UpdateQtd(linha.getIdProduto(), newQtd);
		}
		
		
		ArrayList<PedidoHeader> lista = new ArrayList<>();
		lista.add(pedidoHeader);
		session.setAttribute("listaPedidoHeader", lista);
		view = request.getRequestDispatcher("ListarPedidoHeaderTeste.jsp");
		
		view.forward(request, response);
	}

}
