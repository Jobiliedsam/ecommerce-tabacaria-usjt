package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.service.ClienteService;

public class EditarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		
		
		Cliente cliente = new Cliente();
		ClienteService clienteService = new ClienteService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cliente.setIdCliente(id);
		cliente.setCelular(request.getParameter("celularCliente"));
		cliente.setNomeCompleto(request.getParameter("nomeCliente"));
		cliente.setTelefone(request.getParameter("telefoneCliente"));
		cliente.setEmail(request.getParameter("emailCliente"));
		cliente.setGenero(request.getParameter("generoCliente"));
		cliente.setCpfCnpj(request.getParameter("cpfCliente"));
		cliente.setTipo("Física");
		cliente.setDataDeNascimento(new Date(1995, 19, 10));
		cliente.setRg(request.getParameter("rg"));
		cliente  = clienteService.carregar(cliente.getIdCliente());
		
		request.setAttribute("cliente", cliente);
		view = request.getRequestDispatcher("AlterarCliente.jsp");
		view.forward(request, response);


	}

}
