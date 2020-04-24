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

public class AlterarCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e){
			// TODO: handle exception
		}
		Categoria categoria = new Categoria();
		CategoriaService cs = new CategoriaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		categoria.setIdCategoria(id);
		categoria.setCategoria(pNome);
		categoria.setStatus(pStatus);
		categoria.setDescricao(pDescricao);
		cs.atualizar(categoria);
		
		ArrayList<Categoria> lista = (ArrayList<Categoria>) session.getAttribute("lista");
		int pos = busca(categoria, lista);
		lista.remove(pos);
		lista.add(pos, categoria);
		session.setAttribute("lista", lista);
		request.setAttribute("categoria", categoria);
		view = request.getRequestDispatcher("VisualizarCategoria.jsp");
		
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
