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

public class AlterarProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("idProduto");
		String pNome = request.getParameter("nomeP");
		String pPreco = request.getParameter("preçoF");
		String pCategoria = request.getParameter("categoria");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e) {
			
		}
		
		Produto produto = new Produto();
		produto.setIdProduto(id);
		produto.setNomeP(pNome);
		produto.setPrecoF(pPreco);
		produto.setCategoria(pCategoria);
		produto.setStatus(pStatus);
		produto.setDescricao(pDescricao);
		
		ProdutoService ps = new ProdutoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ps.atualizar(produto);
		ArrayList<Produto> lista = (ArrayList<Produto>)session.getAttribute("lista");
		int pos = busca(produto, lista);
		lista.remove(pos);
		lista.add(pos,produto);
		session.setAttribute("lista", lista);
		request.setAttribute("produto", produto);
		view = request.getRequestDispatcher("VisualizarProduto.jsp");

		view.forward(request, response);

	}

	public int busca(Produto produto, ArrayList<Produto> lista) {
		Produto to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getIdProduto() == produto.getIdProduto()){
				return i;
			}
		}
		return -1;
	}

}
