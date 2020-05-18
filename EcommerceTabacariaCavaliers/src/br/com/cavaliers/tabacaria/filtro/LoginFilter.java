package br.com.cavaliers.tabacaria.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Usuario;

@WebFilter("/controller.do")
public class LoginFilter implements Filter 
{

	public LoginFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Usuario usuario = (Usuario) session.getAttribute("logado");
		Usuario usuario1 = (Usuario) session.getAttribute("logadoAdministrador");
		String path = req.getContextPath();
		String uri = req.getRequestURI();

		String comando = req.getParameter("command");

		if (comando == null) 
		{
			comando = "";
		}

		if (usuario == null && usuario1 == null && !uri.equals(path + "/UsuarioIndex.jsp") && !comando.equals("FazerLogin")
				&& !comando.equals("CriarUsuario") && !comando.equals("Carrinho")) 
		{
			((HttpServletResponse) response).sendRedirect(path + "/UsuarioIndex.jsp");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
