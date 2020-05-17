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

public class CriarProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nomeP");
		double pPreco = Double.parseDouble(request.getParameter("precoF"));
		String pCategoria = request.getParameter("categoria");
		String pFornecedor = request.getParameter("fornecedor");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		int pQuantidade = Integer.parseInt(request.getParameter("quantidade"));
		
		Produto produto = new Produto();
		produto.setNomeP(pNome);
		produto.setPrecoF(pPreco);
		produto.setCategoria(pCategoria);
		produto.setFornecedor(pFornecedor);
		produto.setStatus(pStatus);
		produto.setDescricao(pDescricao);
		produto.setQuantidade(pQuantidade);
		
		ProdutoService ps = new ProdutoService();
		ps.criar(produto);

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		ArrayList<Produto> lista = new ArrayList<>();
		lista.add(produto);
		session.setAttribute("listaProduto", lista);
		view = request.getRequestDispatcher("ListarProduto.jsp");
		
		view.forward(request, response);
		
	}

}
