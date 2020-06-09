package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.PedidoHeader;
import br.com.cavaliers.tabacaria.service.ProdutoService;
import br.com.cavaliers.tabacaria.model.PedidoLine;

public class Carrinho implements Command 
{
	
	public static ArrayList<PedidoLine> listaCarrinho = new ArrayList<>();
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		Cliente cliente = (Cliente)session.getAttribute("currentUser");
		PedidoLine pedidoLine = new PedidoLine();
		PedidoHeader pedidoHeader = new PedidoHeader();
		ProdutoService produtoService = new ProdutoService();
		
		//Produto produtoCarrinho = new Produto();
		int intQtd = 0; 
		
		String sIdProdutoRemove = request.getParameter("itemRemove"); 
		
		Produto produtoCarrinho = null;
		
		
		if (sIdProdutoRemove == null)
		{
			produtoCarrinho = produtoService.carregar(Integer.parseInt(request.getParameter("idProduto")));			
		}
		String quantidade = request.getParameter("qtd");
		
		// Tratando a quantidade 
		if (quantidade != null)
		{
			intQtd = Integer.parseInt(quantidade);
			
			if (intQtd >= produtoCarrinho.getQuantidade()) intQtd = produtoCarrinho.getQuantidade();
			else if (intQtd > 10) intQtd = 10;
			else if (intQtd < 1) intQtd = 1;
		}
		else 
		{
			intQtd = 1;
		}
	
		
		// Criando um produto no formato do carrinho (PedidoLine)
		if (produtoCarrinho != null)
		{
			pedidoLine.setIdProduto(produtoCarrinho.getIdProduto());
			pedidoLine.setNomeDoProduto(produtoCarrinho.getNomeP());
			pedidoLine.setPrecoUnitario(produtoCarrinho.getPrecoF());
			pedidoLine.setQuantidaeProduto(intQtd);
			pedidoLine.setValorProduto(pedidoLine.getPrecoUnitario() * pedidoLine.getQuantidadeProduto());			
		}
		
		int indexPedidoLine = busca(pedidoLine, listaCarrinho);

		
		// Verficando as formas de inserir o produto no carrinho e sua quantidade da maneira correta
		if (listaCarrinho.isEmpty() || (indexPedidoLine == - 1  && sIdProdutoRemove == null) )
		{
			listaCarrinho.add(pedidoLine);			
		} 
		else if (indexPedidoLine != -1 && quantidade == null)
		{
			PedidoLine aux = listaCarrinho.get(indexPedidoLine);
			aux.setQuantidaeProduto(aux.getQuantidadeProduto() + 1); 
			aux.setValorProduto(aux.getPrecoUnitario() * aux.getQuantidadeProduto());
			listaCarrinho.set(indexPedidoLine, aux);
		}
		else if (sIdProdutoRemove == null)
		{
			PedidoLine aux = listaCarrinho.get(indexPedidoLine);
			aux.setQuantidaeProduto(intQtd); 
			aux.setValorProduto(aux.getPrecoUnitario() * aux.getQuantidadeProduto());
			listaCarrinho.set(indexPedidoLine, aux);
			
			session.setAttribute("qtd", null);
		}
		
		// Retirando a compra do carrinho
		if (!listaCarrinho.isEmpty() && sIdProdutoRemove != null)
		{
			int intIdProdutoRemove = Integer.parseInt(sIdProdutoRemove);
			
			listaCarrinho.remove(intIdProdutoRemove);
		}
		

		// Retirar a responsabilidade do calculo do valor total da classe carrinho
		if (!listaCarrinho.isEmpty())
		{

			int quantidadeTotal = 0;
			double valorTotal = 0;
			
			for(PedidoLine item: listaCarrinho)
			{
				quantidadeTotal += item.getQuantidadeProduto();
				valorTotal += item.getValorProduto();
			}
		
			pedidoHeader.setQtdItens(quantidadeTotal);
			pedidoHeader.setValorTotal(valorTotal);
		}
		
		
		if (cliente != null)
		{
			pedidoHeader.setIdCliente(cliente.getIdCliente());
			pedidoHeader.setNomeCliente(cliente.getNomeCompleto());
		}
		
		session.setAttribute("orderHeader", pedidoHeader);
		session.setAttribute("produtosCarrinho", listaCarrinho);
		view = request.getRequestDispatcher("cart.jsp");
		
		view.forward(request, response);
	}
	
	
	
	public int busca(PedidoLine pedidoLine, ArrayList<PedidoLine> lista) 
	{
		PedidoLine to;
		for(int i = 0; i < lista.size(); i++)
		{
			to = lista.get(i);
			if(to.getIdProduto() == pedidoLine.getIdProduto())
			{
				return i;
			}
		}
		return -1;
	}
	
}
