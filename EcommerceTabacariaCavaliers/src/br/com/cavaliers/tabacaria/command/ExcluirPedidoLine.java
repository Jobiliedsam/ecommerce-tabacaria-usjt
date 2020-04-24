package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.PedidoLine;
import br.com.cavaliers.tabacaria.service.PedidoLineService;

public class ExcluirPedidoLine implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("idPedidoLine");
		int id = -1;
		
		try {
			id = Integer.parseInt(pId);
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		PedidoLine pedidoLine = new PedidoLine();
		pedidoLine.setIdPedidoLine(id);
		
		PedidoLineService pls = new PedidoLineService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		pls.excluir(pedidoLine.getIdPedidoLine());
		ArrayList<PedidoLine> lista = (ArrayList<PedidoLine>)session.getAttribute("lista");
		lista.remove(busca(pedidoLine, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPedidoLine.jsp");			
		
		view.forward(request, response);

	}

	public int busca(PedidoLine pedidoLine, ArrayList<PedidoLine> lista) {
		PedidoLine to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getIdPedidoLine() == pedidoLine.getIdPedidoLine()){
				return i;
			}
		}
		return -1;

	}

}
