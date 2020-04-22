package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.UsuarioService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet {
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
    	String pId = request.getParameter("id");
    	String pEmail = request.getParameter("Email");
		String pPassword = request.getParameter("Password");
		String pAcao = request.getParameter("acao");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		}
		catch(NumberFormatException e){
			
		}
		
		
		Usuario usuario = new Usuario();
		UsuarioService us = new UsuarioService();
		us.criar(usuario);
		usuario = us.carregar(usuario.getId());
		
		usuario.setId(id);
		usuario.setEmail(pEmail);
		usuario.setPassword(pPassword);
		RequestDispatcher view = null;
		if(pAcao.equals("Login")) {
			
			us.verificausuario(pEmail, pPassword);
			view = request.getRequestDispatcher("Login.jsp");
		}
		
		Usuario usuarioTeste = us.carregar(usuario.getId());
		
		System.out.println(usuarioTeste.toString());
		
		response.getStatus();
		
        //enviar para o jsp
        request.setAttribute("usuario", usuario);
        
        
        request.getRequestDispatcher("Usuario.jsp");
        view.forward(request, response);
        
    }
    
}