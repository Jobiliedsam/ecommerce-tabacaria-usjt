package Teste;

import model.*;
import service.*;
import java.sql.SQLException;
import java.util.Date;

public class TesteAll {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {

		// Criando um cliente 
		System.out.println("Criando um cliente!!!");
		
		
		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente();
		
		cliente.setNomeCompleto("Jailson Santos");
		cliente.setCelular("1198742-2324");
		cliente.setCpfCnpj("23412312390");
		cliente.setEmail("jailsonsantos@email.com");
		cliente.setGenero("M");
		cliente.setTipo("Fisica");
		cliente.setTelefone("1123456798");
		cliente.setDataDeNascimento(new Date(1995, 19, 10));

		int idCliente = clienteService.criar(cliente);
		cliente.setIdCliente(idCliente);
		
		
		System.out.println("IdCliente: " + cliente.getIdCliente());
		System.out.println("Nome Cliente: " + cliente.getNomeCompleto());
		
		
		// Criando um endereço
		System.out.println("\nCriando um Endereço!!!");
		
		EnderecoService enderecoService = new EnderecoService();
		Endereco endereco = new Endereco();
		
		endereco.setIdCliente(cliente.getIdCliente());
		endereco.setEnderecoP("Rua Borboletas Pisicodelicas N° 450");
		endereco.setEnderecoS("Não Possui");
		endereco.setCep("98080-21");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setComplemento("Longe");
		endereco.setIdEndereco(enderecoService.criar(endereco));
		
		Endereco enderecoTeste = enderecoService.carregar(endereco.getIdCliente());
		
		System.out.println("Id Endereco: " + enderecoTeste.getIdEndereco());
		System.out.println("Id Cliente: " + enderecoTeste.getIdCliente());
		
		// Criando uma categoria
		System.out.println("\nCriando uma categoria");
		
		CategoriaService categoriaService = new CategoriaService();
		Categoria categoria = new Categoria();
		
		categoria.setCategoria("Bebidas");
		categoria.setDescricao("Bebidas para acompanhar as paradas");
		categoria.setStatus("Ativo");
		categoria.setIdCategoria(categoriaService.criar(categoria));
		
		Categoria categoriaTeste = categoriaService.carregar(categoria.getIdCategoria());
		
		System.out.println("Id Categoria: " + categoriaTeste.getIdCategoria());
		System.out.println("Nome da Categoria: " + categoriaTeste.getCategoria());
		
		
		// Criando um produto
		System.out.println("\nCriando um produto!!!");
		
		ProdutoService produtoService = new ProdutoService();
		Produto produto = new Produto();
		
		produto.setNomeP("Coca-Cola Lata");
		produto.setPrecoF(7.98);
		produto.setDescricao("Bebida sabor cola enlatada 375ml");
		produto.setCategoria("Bebidas");
		produto.setStatus("Ativo");
		produto.setIdProduto(produtoService.criar(produto));
		
		Produto produtoTeste = produtoService.carregar(produto.getIdProduto());
		
		System.out.println("Id Produto: " + produtoTeste.getIdProduto());
		System.out.println("Nome do Produto: " + produtoTeste.getNomeP());
		
		// Criando um pedidoHeader
		System.out.println("\nCriando um Pedido Header!!!");
		
		PedidoHeaderService pedidoHeaderService = new PedidoHeaderService();
		PedidoHeader pedidoHeader = new PedidoHeader();
		
		pedidoHeader.setIdCliente(cliente.getIdCliente());
		pedidoHeader.setNomeCliente(cliente.getNomeCompleto());
		pedidoHeader.setQtdItens(7);
		pedidoHeader.setValorTotal(55.86);
		pedidoHeader.setIdPedido(pedidoHeaderService.criar(pedidoHeader));
		
		PedidoHeader pedidoHeaderTeste = pedidoHeaderService.carregar(pedidoHeader.getIdPedido());
		pedidoHeader.setDataHoraCriacao(pedidoHeaderTeste.getDataHoraCriacao());
		
		System.out.println("Id Cliente: " + pedidoHeaderTeste.getIdCliente() + " ");
		System.out.println("Id Pedido: " + pedidoHeaderTeste.getIdPedido());
		System.out.println("Data e Hora: " + pedidoHeaderTeste.getDataHoraCriacao());
		
		// Criando um pedidoLine
		System.out.println("\nCriando um Pedido Line");
		
		PedidoLineService pedidoLineService = new PedidoLineService();
		PedidoLine pedidoLine = new PedidoLine();
		
		pedidoLine.setIdPedidoHeader(pedidoHeaderTeste.getIdPedido());
		pedidoLine.setIdProduto(produtoTeste.getIdProduto());
		pedidoLine.setNomeDoProduto(produto.getNomeP());
		pedidoLine.setPrecoUnitario(produtoTeste.getPrecoF());
		pedidoLine.setQuantidaeProduto(7);
		pedidoLine.setValorProduto(55.86);
		pedidoLine.setIdPedioLine(pedidoLineService.criar(pedidoLine));
		
		PedidoLine pedidoLineTeste = pedidoLineService.carregar(pedidoLine.getIdPedioLine());
		
		System.out.println("Id Pedido:" + pedidoLineTeste.getIdPedioLine());
		
	}

}
