package br.com.cavaliers.tabacaria.service;

import br.com.cavaliers.tabacaria.dao.ClienteDAO;
import br.com.cavaliers.tabacaria.model.Cliente;

public class ClienteService {

	ClienteDAO dao = new ClienteDAO();
	
	public int criar(Cliente cliente) {
		return dao.inserir(cliente);
	}
	
	public void atualizar(Cliente cliente){
		dao.atualizar(cliente);
	}
		
	public void excluir(int id){
		dao.excluir(id);
	}
		
	public Cliente carregar(int id){
		return dao.carregar(id);
	}
}
