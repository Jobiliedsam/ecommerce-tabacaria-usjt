package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.ClienteService;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class CriarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();
		ClienteService clienteService = new ClienteService();
		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cliente.setCelular(request.getParameter("celularCliente"));
		cliente.setNomeCompleto(request.getParameter("nomeCliente"));
		cliente.setTelefone(request.getParameter("telefoneCliente"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setGenero(request.getParameter("generoCliente"));
		cliente.setCpfCnpj(request.getParameter("cpfCliente"));
		cliente.setTipo("F�sica");
		cliente.setDataDeNascimento(new Date(1995, 19, 10));
		cliente.setRg(request.getParameter("rg"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(request.getParameter("password"));
		usuario.setTipo(request.getParameter("tipo"));
		clienteService.criar(cliente);
		us.criar(usuario);
		
		
		ArrayList<Cliente> lista =  new ArrayList<>();
		lista.add(cliente);
		session.setAttribute("listaCliente", lista);
		view = request.getRequestDispatcher("UsuarioIndex.jsp");
		view.forward(request, response);


	}

}
