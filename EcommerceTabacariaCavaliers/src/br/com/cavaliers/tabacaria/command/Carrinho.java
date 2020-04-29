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


public class Carrinho implements Command 
{
	
	public static ArrayList<Produto> listaCarrinho = new ArrayList<>();
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProdutoService produtoService = new ProdutoService();
		Produto produtoCarrinho = new Produto();
		produtoCarrinho = produtoService.carregar(Integer.parseInt(request.getParameter("idProduto")));
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (produtoCarrinho != null)
		{
			listaCarrinho.add(produtoCarrinho);			
		}
		session.setAttribute("produtosCarrinho", listaCarrinho);
		view = request.getRequestDispatcher("cart.jsp");
		
		view.forward(request, response);
	}
	
	
	
}
