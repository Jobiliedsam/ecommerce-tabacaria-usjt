package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.service.FornecedorService;

/**
 * Servlet implementation class ManterFornecedorController
 */
@WebServlet("/ManterFornecedor.do")
public class ManterFornecedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fornecedor fornecedor = new Fornecedor();
		FornecedorService fornecedorService = new FornecedorService();

		fornecedor.setNomeFornecedor(request.getParameter("nomeFornecedor"));
		fornecedor.setCnpj(request.getParameter("cnpj"));
		fornecedor.setContatoTelefone(request.getParameter("contatoTelefone"));
		fornecedor.setContatoEmail(request.getParameter("contatoEmail"));
		fornecedor.setDescricao(request.getParameter("descricao"));
		fornecedor.setIdFornecedor(fornecedorService.criar(fornecedor));

		Fornecedor fornecedorTeste = fornecedorService.carregar(fornecedor.getIdFornecedor());

		System.out.println(fornecedorTeste.toString());

		response.getStatus();
		
		//enviar para o jsp
		request.setAttribute("fornecedor", fornecedor);

		RequestDispatcher view = request.getRequestDispatcher("Fornecedor.jsp");
		view.forward(request, response);
	}

}
