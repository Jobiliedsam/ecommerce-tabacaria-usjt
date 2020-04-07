package br.com.cavaliers.tabacaria.service;

import br.com.cavaliers.tabacaria.dao.UsuarioDAO;
import br.com.cavaliers.tabacaria.model.Usuario;

public class UsuarioService {
	
	UsuarioDAO dao = new UsuarioDAO();

	public int criar(Usuario usuario) {
		return dao.inserir(usuario);
	}

	public void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Usuario carregar(int id) {
		return dao.carregar(id);
	}
	public boolean verificausuario(String email, String password) {
		return dao.verificausuario(email, password);
	}

}
