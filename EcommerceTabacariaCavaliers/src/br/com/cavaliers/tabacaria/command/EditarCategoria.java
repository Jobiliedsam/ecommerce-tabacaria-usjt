package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Categoria;
import br.com.cavaliers.tabacaria.service.CategoriaService;


public class EditarCategoria implements Command {

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
				
			}
			Categoria categoria = new Categoria();
			CategoriaService cs = new CategoriaService();
			RequestDispatcher view = null;
			
			categoria.setIdCategoria(id);
			categoria.setCategoria(pNome);
			categoria.setStatus(pStatus);
			categoria.setDescricao(pDescricao);
			
			
			categoria  = cs.carregar(categoria.getIdCategoria());
			request.setAttribute("categoria", categoria);
			view = request.getRequestDispatcher("AlterarCategoria.jsp");
			view.forward(request, response);
	}

}
