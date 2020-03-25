package service;

import model.Endereco;
import dao.EnderecoDAO;

public class EnderecoService 
{

    EnderecoDAO endDAO = new EnderecoDAO();

    public int criar(Endereco endereco)
    {
        return endDAO.inserir(endereco);
    }

    public void atualizar(Endereco endereco)
    {
        endDAO.atualizar(endereco);
    }

    public void excluir(int idCliente)
    {
        endDAO.excluir(idCliente);
    }

    public Endereco carregar(int idCliente)
    {
        return endDAO.carregar(idCliente);
    }

}
