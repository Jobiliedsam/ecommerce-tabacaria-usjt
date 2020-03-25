package service;

import model.Categoria;
import dao.CategoriaDAO;

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

}
