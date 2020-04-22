package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.service.ProdutoService;

public class EditarProduto implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("idProduto");
		String pNome = request.getParameter("nomeP");
		String pPreco = request.getParameter("preçoF");
		String pCategoria = request.getParameter("categoria");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e) {
			
		}
		
		Produto produto = new Produto();
		produto.setIdProduto(id);
		produto.setNomeP(pNome);
		produto.setPrecoF(pPreco);
		produto.setCategoria(pCategoria);
		produto.setStatus(pStatus);
		produto.setDescricao(pDescricao);
		
		ProdutoService ps = new ProdutoService();
		RequestDispatcher view = null;
		
		produto = ps.carregar(produto.getIdProduto());
		request.setAttribute("produto", produto);
		view = request.getRequestDispatcher("AlterarProduto.jsp");
		view.forward(request, response);
	}

}
