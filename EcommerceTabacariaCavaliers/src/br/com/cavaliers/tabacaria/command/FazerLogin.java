package br.com.cavaliers.tabacaria.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.Endereco;
import br.com.cavaliers.tabacaria.service.ClienteService;
import br.com.cavaliers.tabacaria.service.UsuarioService;
import br.com.cavaliers.tabacaria.service.EnderecoService;

public class FazerLogin implements Command 
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String pEmail = request.getParameter("email");
		String pPassword = request.getParameter("password");
		
		// Classes para já trazer as informações do usuário
		ClienteService cs = new ClienteService();
		EnderecoService es = new EnderecoService();
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail(pEmail);
		usuario.setPassword(pPassword);

		UsuarioService us = new UsuarioService();
		
		boolean isUser = us.validar(usuario);
		
		if(isUser && usuario.getTipo().equals("Administrativo")) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("invalidLogin", 0);
			session.setAttribute("logadoAdministrador", usuario);
			response.sendRedirect("administration.jsp");
		}
		else if(isUser) 
		{
			Cliente cliente = cs.carregar(usuario.getId());
			Endereco endereco = es.carregar(cliente.getIdCliente());
			
			HttpSession session = request.getSession();
			session.setAttribute("invalidLogin", 0);
			session.setAttribute("logado", usuario);
			session.setAttribute("currentUser", cliente);
			session.setAttribute("currentUserEndereco", endereco);
			response.sendRedirect("index.jsp");
		}
		else 
		{
			HttpSession session = request.getSession();
			session.setAttribute("invalidLogin", 1);
			response.sendRedirect("UsuarioIndex.jsp");
			System.out.println(usuario + "incorreto");
			
		}
		
	}

}
