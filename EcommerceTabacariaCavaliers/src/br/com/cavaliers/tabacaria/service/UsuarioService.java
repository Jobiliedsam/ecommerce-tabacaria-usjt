package br.com.cavaliers.tabacaria.service;

import java.util.ArrayList;

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

	public void excluir(int idUsuario) {
		dao.excluir(idUsuario);
	}

	public Usuario carregar(int id) {
		return dao.carregar(id);
	}
	public  boolean validar(Usuario usuario) {
		return dao.validar(usuario); 
	}
	public ArrayList<Usuario> buscarUsuario() {
		return dao.buscarUsuario();
	}
	public ArrayList<Usuario> buscarUsuario(String chave){
		return dao.buscarUsuario(chave);
	}

}