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

public class ExcluirUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		Usuario usuario = new Usuario();
		usuario.setId(id);
		
		UsuarioService us = new UsuarioService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		us.excluir(usuario.getId());
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session.getAttribute("lista");
		lista.remove(busca(usuario, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("UsuarioLista.jsp");
		view.forward(request, response);

	}
	public int busca(Usuario usuario, ArrayList<Usuario> lista) {
		Usuario to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == usuario.getId()) {
				return i;
			}
		}
		return -1;
	}


}
