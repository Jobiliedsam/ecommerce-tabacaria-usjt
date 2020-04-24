package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class VisualizarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pEmail = request.getParameter("email");
		String pPassword = request.getParameter("password");
		int id = -1;

		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		Usuario usuario = new Usuario();
		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		usuario.setId(id);
		usuario.setEmail(pEmail);
		usuario.setPassword(pPassword);
		usuario = us.carregar(usuario.getId());

		request.setAttribute("usuario", usuario);
		
		view = request.getRequestDispatcher("VisualizarUsuario.jsp");
		view.forward(request, response);

	}

}
