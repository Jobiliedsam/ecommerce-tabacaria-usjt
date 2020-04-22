package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.service.FornecedorService;

public class ListarFornecedor implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		FornecedorService fs = new FornecedorService();
		ArrayList<Fornecedor> lista = null;
		HttpSession session = request.getSession();

			if (chave != null && chave.length() > 0) {
				lista = fs.listarFornecedores(chave);
			} else {
				lista = fs.listarFornecedores();
			}
			session.setAttribute("lista", lista);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarFornecedor.jsp");
		dispatcher.forward(request, response);

	}

}
