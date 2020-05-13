package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.service.FornecedorService;

public class ExcluirFornecedor implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setIdFornecedor(id);
		
		FornecedorService fs = new FornecedorService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		fs.excluir(fornecedor.getIdFornecedor());
		ArrayList<Fornecedor> lista = (ArrayList<Fornecedor>)session.getAttribute("listaFornecedor");
		lista.remove(busca(fornecedor, lista));
		session.setAttribute("listaFornecedor", lista);
		view = request.getRequestDispatcher("ListarFornecedor.jsp");			
		
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
