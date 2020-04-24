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

public class CriarCategoria implements Command 
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String pNome = request.getParameter("nomeCategoria");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		
			
		Categoria categoria = new Categoria();
		categoria.setCategoria(pNome);
		categoria.setStatus(pStatus);
		categoria.setDescricao(pDescricao);
		
		
		CategoriaService cs = new CategoriaService();
		categoria.setIdCategoria(cs.criar(categoria));
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		
		ArrayList<Categoria> lista = new ArrayList<>();
		lista.add(categoria);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("CategoriaLista.jsp");
		
		view.forward(request, response);
	}

}
