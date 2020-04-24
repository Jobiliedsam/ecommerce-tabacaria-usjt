package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.service.ClienteService;


public class ListarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ClienteService clienteService = new ClienteService();
		RequestDispatcher view = null;
		ArrayList<Cliente> lista = null;
		HttpSession session = request.getSession();
		
		if (chave != null && chave.length() > 0) {
			lista = clienteService.buscarCliente(chave);
		} else {
			lista = clienteService.buscarCliente();
		}
		session.setAttribute("lista", lista);
	 

	RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteLista.jsp");
	dispatcher.forward(request, response);


	}

}
