package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pEmail = request.getParameter("email");
		String pPassword = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(pEmail);
		usuario.setPassword(pPassword);

		UsuarioService us = new UsuarioService();
		
		if(us.validar(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println(usuario + "logado");
		}else {
			System.out.println(usuario + "incorreto");
			throw new ServletException("Email / senha negados");
		}
		response.sendRedirect("index.jsp");
	}

}
