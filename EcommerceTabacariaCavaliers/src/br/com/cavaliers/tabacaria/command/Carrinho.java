package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.service.ProdutoService;
import br.com.cavaliers.tabacaria.model.PedidoLine;

public class Carrinho implements Command 
{
	
	public static ArrayList<PedidoLine> listaCarrinho = new ArrayList<>();
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProdutoService produtoService = new ProdutoService();
		Produto produtoCarrinho = new Produto();
		produtoCarrinho = produtoService.carregar(Integer.parseInt(request.getParameter("idProduto")));
		
		PedidoLine pedidoLine = new PedidoLine();
		
		if (produtoCarrinho != null)
		{
			pedidoLine.setIdProduto(produtoCarrinho.getIdProduto());
			pedidoLine.setNomeDoProduto(produtoCarrinho.getNomeP());
			pedidoLine.setPrecoUnitario(produtoCarrinho.getPrecoF());
			pedidoLine.setQuantidaeProduto(1);
			pedidoLine.setValorProduto(pedidoLine.getPrecoUnitario() * pedidoLine.getQuantidadeProduto());			
		}
		
		int indexPedidoLine = busca(pedidoLine, listaCarrinho);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (listaCarrinho.isEmpty() || indexPedidoLine == - 1)
		{
			listaCarrinho.add(pedidoLine);			
		} 
		else if (indexPedidoLine != -1)
		{
			PedidoLine aux = listaCarrinho.get(indexPedidoLine);
			aux.setQuantidaeProduto(aux.getQuantidadeProduto() + 1); 
			aux.setValorProduto(aux.getPrecoUnitario() * aux.getQuantidadeProduto());
			listaCarrinho.set(indexPedidoLine, aux);
		}
		session.setAttribute("produtosCarrinho", listaCarrinho);
		view = request.getRequestDispatcher("cart.jsp");
		
		view.forward(request, response);
	}
	
	public int busca(PedidoLine pedidoLine, ArrayList<PedidoLine> lista) 
	{
		PedidoLine to;
		for(int i = 0; i < lista.size(); i++)
		{
			to = lista.get(i);
			if(to.getIdProduto() == pedidoLine.getIdProduto())
			{
				return i;
			}
		}
		return -1;
	}
	
}
