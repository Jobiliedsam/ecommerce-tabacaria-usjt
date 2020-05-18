package br.com.cavaliers.tabacaria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.command.Command;

@WebServlet("/controller.do")
@MultipartConfig
public class ServeltController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public ServeltController() 
	{
		super();
	}

	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("br.com.cavaliers.tabacaria.command." + request.getParameter("command")).newInstance();
			comando.executar(request, response);
		}
		catch(InstantiationException  | IllegalAccessException | ClassNotFoundException e) 
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		doExecute(request, response);
	}

}
