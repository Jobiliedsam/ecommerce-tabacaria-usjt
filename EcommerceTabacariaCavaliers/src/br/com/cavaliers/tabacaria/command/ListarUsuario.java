package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class ListarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		ArrayList<Usuario> lista = null;
		
		if (chave != null && chave.length() > 0) {
			lista = us.buscarUsuario(chave);
		} else {
			lista = us.buscarUsuario();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher view = request.getRequestDispatcher("CategoriaLista.");
		view.forward(request, response);

	}

}
