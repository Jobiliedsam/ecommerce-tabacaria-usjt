package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.service.FornecedorService;

public class AlterarFornecedor implements Command {

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
		HttpSession session = request.getSession();
		
		fs.atualizar(fornecedor);
		ArrayList<Fornecedor> lista = (ArrayList<Fornecedor>)session.getAttribute("lista");
		int pos = busca(fornecedor, lista);
		lista.remove(pos);
		lista.add(pos,fornecedor);
		session.setAttribute("lista", lista);
		request.setAttribute("fornecedor", fornecedor);
		view = request.getRequestDispatcher("VisualizarFornecedor.jsp");

		view.forward(request, response);
	}
		public int busca(Fornecedor fornecedor, ArrayList<Fornecedor> lista) {
			Fornecedor to;
			for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getIdFornecedor() == fornecedor.getIdFornecedor()){
					return i;
				}
			}
			return -1;
	}

}
