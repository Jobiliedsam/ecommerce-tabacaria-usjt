package br.com.cavaliers.tabacaria.service;

import java.util.ArrayList;

import br.com.cavaliers.tabacaria.dao.CategoriaDAO;
import br.com.cavaliers.tabacaria.model.Categoria;

public class CategoriaService {
	
	CategoriaDAO dao = new CategoriaDAO();

	public int criar(Categoria categoria) {
		return dao.inserir(categoria);
	}

	public void atualizar(Categoria categoria) {
		dao.atualizar(categoria);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Categoria carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Categoria> carregarAll() {
		return dao.buscarCategoria();
	}
	public ArrayList<Categoria> buscarCategoria(String chave){
		return dao.buscarCategoria(chave);
	}

}
