package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.service.ProdutoService;

@WebServlet("/ManterProduto.do")
public class ManterProdutoController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProdutoService produtoService = new ProdutoService();
		
		Produto produto = new Produto();
		
		produto.setNomeP(request.getParameter("nomeProduto"));
		produto.setPrecoF(Double.parseDouble(request.getParameter("precoProduto")));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setStatus("Ativo");
		produto.setIdProduto(produtoService.criar(produto));
		
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

}
