package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.Endereco;
import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.ClienteService;
import br.com.cavaliers.tabacaria.service.EnderecoService;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class ExcluirCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		String pId1 = request.getParameter("idUsuario");
		int idUsuario = -1;

		try {
			idUsuario = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		String pId2 = request.getParameter("idEndereco");
		int idEndereco = -1;

		try {
			idEndereco = Integer.parseInt(pId2);
		} catch (NumberFormatException e) {

		}

		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();
		Endereco endereco = new Endereco();
		
		cliente.setIdCliente(id);
		usuario.setId(idUsuario);
		endereco.setIdCliente(id);
		
		ClienteService clienteService = new ClienteService();
		UsuarioService us = new UsuarioService();
		EnderecoService enderecoService = new EnderecoService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		clienteService.excluir(id);
		us.excluir(idUsuario);
		enderecoService.excluir(cliente.getIdCliente());
		
		ArrayList<Cliente> lista = (ArrayList<Cliente>) session.getAttribute("listaCliente");
		lista.remove(busca(cliente, lista));
		session.setAttribute("listaCliente", lista);
		view = request.getRequestDispatcher("ClienteLista.jsp");
		view.forward(request, response);

	}

	public int busca(Cliente cliente, ArrayList<Cliente> lista) {
		Cliente to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdCliente() == cliente.getIdCliente()) {
				return i;
			}
		}
		return -1;
	}

}
