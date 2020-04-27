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

public class ListarProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ProdutoService ps = new ProdutoService();
		ArrayList<Produto> lista = null;
		HttpSession session = request.getSession();

			if (chave != null && chave.length() > 0) {
				lista = ps.carregarAll(chave);
			} else {
				lista = ps.carregarAll();
			}
			session.setAttribute("lista", lista);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarProduto.jsp");
		dispatcher.forward(request, response);

	}

}
