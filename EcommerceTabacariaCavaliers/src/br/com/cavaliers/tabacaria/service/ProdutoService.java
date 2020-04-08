package br.com.cavaliers.tabacaria.service;

import java.util.ArrayList;

import br.com.cavaliers.tabacaria.dao.ProdutoDAO;
import br.com.cavaliers.tabacaria.model.Produto;

public class ProdutoService 
{
	ProdutoDAO dao = new ProdutoDAO();

	public int criar(Produto produto) {
		return dao.inserir(produto);
	}

	public void atualizar(Produto produto) {
		dao.atualizar(produto);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Produto carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Produto> carregarAll() {
		return dao.buscarProduto();
	}
 
}
