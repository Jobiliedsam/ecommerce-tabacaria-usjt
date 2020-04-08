package br.com.cavaliers.tabacaria.service;

import br.com.cavaliers.tabacaria.model.Fornecedor;
import br.com.cavaliers.tabacaria.dao.FornecedorDAO;


public class FornecedorService {
FornecedorDAO dao = new FornecedorDAO();
	
	public int criar(Fornecedor fornecedor) {
		return dao.inserir(fornecedor);
	}
	
	public void atualizar(Fornecedor fornecedor){
		dao.atualizar(fornecedor);
	}
		
	public void excluir(int id){
		dao.excluir(id);
	}
		
	public Fornecedor carregar(int id){
		return dao.carregar(id);
	}
}
