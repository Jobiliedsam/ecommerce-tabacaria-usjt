package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Categoria;
import br.com.cavaliers.tabacaria.service.CategoriaService;

/**
 * Servlet implementation class ManterCategoriaController
 */
@WebServlet("/ManterCategoria.do")
public class ManterCategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nomeCategoria");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		int id = -1;

		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Categoria categoria = new Categoria();
		CategoriaService cs = new CategoriaService();

		categoria.setCategoria(pNome);
		categoria.setStatus(pStatus);
		categoria.setDescricao(pDescricao);
		categoria.setIdCategoria(id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		if (pAcao.equals("Criar")) {
			cs.criar(categoria);
			ArrayList<Categoria> lista = new ArrayList<>();
			lista.add(categoria);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("CategoriaLista.jsp");
		} else if (pAcao.equals("Excluir")) {
			cs.excluir(categoria.getIdCategoria());
			ArrayList<Categoria> lista = (ArrayList<Categoria>) session.getAttribute("lista");
			lista.remove(busca(categoria, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("CategoriaLista.jsp");
		} else if (pAcao.equals("Alterar")) {
			cs.atualizar(categoria);
			ArrayList<Categoria> lista = (ArrayList<Categoria>) session.getAttribute("lista");
			int pos = busca(categoria, lista);
			lista.remove(pos);
			lista.add(pos, categoria);
			session.setAttribute("lista", lista);
			request.setAttribute("categoria", categoria);
			view = request.getRequestDispatcher("VisualizarCategoria.jsp");
		} else if (pAcao.equals("Visualizar")) {
			categoria = cs.carregar(categoria.getIdCategoria());
			request.setAttribute("categoria", categoria);
			view = request.getRequestDispatcher("VisualizarCategoria.jsp");
		} else if (pAcao.equals("Editar")) {
			categoria = cs.carregar(categoria.getIdCategoria());
			request.setAttribute("categoria", categoria);
			view = request.getRequestDispatcher("AlterarCategoria.jsp");
		}

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
