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

/**
 * Servlet Filter implementation class LoginFilter1
 */
@WebFilter(urlPatterns = {"/AlterarCategoria.jsp","/AlterarCliente.jsp", "/AlterarFornecedor.jsp", "/AlterarProduto.jsp", "/AlterarUsuario.jsp",
		"/CategoriaIndex.jsp", "/ClienteIndex.jsp", "/CriarFornecedor.jsp","/CategoriaLista.jsp", "/ClienteLista.jsp", "/UsuarioLista.jsp","/CriarProduto.jsp",
		"/VisualizarCategoria.jsp", "/VisualizarCliente.jsp", "/VisualizarFornecedor.jsp", "/VisualizarProduto.jsp", "/VisualizarUsuario.jsp","/ListarFornecedor.jsp","/administration.jsp"})
public class LoginFilter1 implements Filter {

	 public LoginFilter1() {
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see Filter#destroy()
		 */
		public void destroy() {
			// TODO Auto-generated method stub
		}

		/**
		 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
		 */
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			
			Usuario usuario1 = (Usuario)session.getAttribute("logadoAdministrador");
			
			String path = req.getContextPath();
			String uri = req.getRequestURI();
			
			String comando = req.getParameter("command");
			
			
			if(comando == null) {
				comando = "";
			}
			
			if(usuario1 == null && !uri.equals(path+ "/UsuarioIndex.jsp") 
				&& !comando.equals("FazerLogin")&& !comando.equals("CriarUsuario")
				&& !comando.equals("Carrinho"))
			{	
				((HttpServletResponse)response).sendRedirect(path + "/UsuarioIndex.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}

		public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}

	}