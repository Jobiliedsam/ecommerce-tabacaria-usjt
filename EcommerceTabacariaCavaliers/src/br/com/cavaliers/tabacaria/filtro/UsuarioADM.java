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
 * Servlet Filter implementation class UsuarioADM
 */
@WebFilter("/controller.do")
public class UsuarioADM implements Filter {

    
    public UsuarioADM() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("Administrativo");
		
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		
		String comando = req.getParameter("command");
		
		
		if(comando == null) {
			comando = "";
		}
		
		if(usuario == null && uri.equals(path+ "/FornecedorIndex.jsp") 
			&& comando.equals("CriarFornecedor")&& comando.equals("AlterarFornecedor")
			&& comando.equals("ExcluirFornecedor") || uri.equals(path+ "/CategoriaIndex.jsp") && comando.equals("AlterarCategoria")
			|| comando.equals("AlterarProduto"))
		{	
			((HttpServletResponse)response).sendRedirect(path + "/UsuarioIndex.jsp");
		}else {
			chain.doFilter(request, response);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
