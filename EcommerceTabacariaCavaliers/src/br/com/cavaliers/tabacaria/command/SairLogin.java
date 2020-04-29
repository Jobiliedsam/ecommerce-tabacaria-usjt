package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class SairLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("logado");
		UsuarioService us = new UsuarioService(); 
		
		if(us.validar(usuario)) {
			session.setAttribute("logado", null);
			System.out.println("Deslogou");
		}
		response.sendRedirect("UsuarioIndex.jsp");
	}

}
