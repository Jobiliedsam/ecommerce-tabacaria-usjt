package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Categoria;
import br.com.cavaliers.tabacaria.service.CategoriaService;
/**
 * Servlet implementation class ManterCategoriaController
 */
@WebServlet("/ManterCategoria.do")
public class ManterCategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pNome = request.getParameter("nomeCategoria");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		
		Categoria categoria = new Categoria();
		CategoriaService cs = new CategoriaService();
		cs.criar(categoria);
		categoria = cs.carregar(categoria.getIdCategoria());
		
		categoria.setCategoria(pNome);
		categoria.setStatus(pStatus);
		categoria.setDescricao(pDescricao);
		
		
		Categoria categoriaTeste = cs.carregar(categoria.getIdCategoria());
		
		System.out.println(categoriaTeste.toString());
		
		response.getStatus();
		
        //enviar para o jsp
        request.setAttribute("categoria", categoria);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Categoria.jsp");
        view.forward(request, response);
        
    }
    
}

