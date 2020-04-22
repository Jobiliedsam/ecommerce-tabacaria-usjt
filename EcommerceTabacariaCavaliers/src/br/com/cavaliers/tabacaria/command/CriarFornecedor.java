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

public class CriarFornecedor implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nomeFornecedor");
		String pCnpj = request.getParameter("cnpj");
		String pFone = request.getParameter("contatoTelefone");
		String pEmail = request.getParameter("contatoTelefone");
		String pDescricao = request.getParameter("descricao");
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFornecedor(pNome);
		fornecedor.setCnpj(pCnpj);
		fornecedor.setContatoTelefone(pFone);
		fornecedor.setContatoEmail(pEmail);
		fornecedor.setDescricao(pDescricao);
		
		
		FornecedorService fs = new FornecedorService();
		fs.criar(fornecedor);

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		ArrayList<Fornecedor> lista = new ArrayList<>();
		lista.add(fornecedor);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarFornecedor.jsp");
		
		view.forward(request, response);
		
	}

}
