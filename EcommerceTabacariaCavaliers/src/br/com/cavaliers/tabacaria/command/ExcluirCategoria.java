package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Categoria;
import br.com.cavaliers.tabacaria.service.CategoriaService;

public class ExcluirCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Categoria categoria = new Categoria();
		categoria.setIdCategoria(id);
		
		CategoriaService cs = new CategoriaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		cs.excluir(categoria.getIdCategoria());
		ArrayList<Categoria> lista = (ArrayList<Categoria>) session.getAttribute("lista");
		lista.remove(busca(categoria, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("CategoriaLista.");
		
		view.forward(request, response);

	}

	public int busca(Categoria categoria, ArrayList<Categoria> lista) {
		Categoria to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdCategoria() == categoria.getIdCategoria()) {
				return i;
			}
		}
		return -1;
	}
}
