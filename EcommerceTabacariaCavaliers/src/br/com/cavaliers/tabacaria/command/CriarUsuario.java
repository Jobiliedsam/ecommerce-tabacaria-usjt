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

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pEmail = request.getParameter("email");
		String pPassword = request.getParameter("password");
		String pTipo = request.getParameter("tipo");
		
		Usuario usuario = new Usuario();
		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		usuario.setEmail(pEmail);
		usuario.setPassword(pPassword);
		usuario.setTipo(pTipo);
		us.criar(usuario);
		
		ArrayList<Usuario> lista = new ArrayList<>();
		lista.add(usuario);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("UsuarioIndex.jsp");
		view.forward(request, response);


	}

}
