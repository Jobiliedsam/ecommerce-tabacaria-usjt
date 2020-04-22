package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.service.FornecedorService;

public class EditarFornecedor implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("idFornecedor");
		String pNome = request.getParameter("nomeFornecedor");
		String pCnpj = request.getParameter("cnpj");
		String pFone = request.getParameter("contatoTelefone");
		String pEmail = request.getParameter("contatoEmail");
		String pDescricao = request.getParameter("descricao");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e) {
			
		}
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setIdFornecedor(id);
		fornecedor.setNomeFornecedor(pNome);
		fornecedor.setCnpj(pCnpj);
		fornecedor.setContatoTelefone(pFone);
		fornecedor.setContatoEmail(pEmail);
		fornecedor.setDescricao(pDescricao);
		
		FornecedorService fs = new FornecedorService();
		RequestDispatcher view = null;
		
		fornecedor = fs.carregar(fornecedor.getIdFornecedor());
		request.setAttribute("fornecedor", fornecedor);
		view = request.getRequestDispatcher("AlterarFornecedor.jsp");
		view.forward(request, response);

	}

}
