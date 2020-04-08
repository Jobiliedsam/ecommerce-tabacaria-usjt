package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO 
{
    public int inserir(Produto produto)
    {
        String sqlInsert = "INSERT INTO `produto` (`Nome_Produto`, `Nome_Categoria`, `Preco`, `Fornecedor`, `Status_Produto`, `Descricao`)" +
            "VALUES (?, ?, ?, ?, ?, ?);";

        
		try (Connection connection = new ConnectionFactory().obterConexao();
			PreparedStatement stm = connection.prepareStatement(sqlInsert);)
		{
            stm.setString(1, produto.getNomeP());
            stm.setString(2, produto.getCategoria());
            stm.setDouble(3, produto.getPrecoF());
            stm.setString(4, "Esqueceram o atributo Implementar");
            stm.setString(5, produto.getStatus());
            stm.setString(6, produto.getDescricao());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					produto.setIdProduto(resultSet.getInt(1));
				}
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
			}
		}
		catch (SQLException sqlException) 
		{
			sqlException.printStackTrace();
		}
		
		return produto.getIdProduto();
    }


    public void atualizar(Produto produto)
    {
        String sqlUpdate = "UPDATE `produto` SET `Nome_Produto` = ?, `Nome_Categoria` = ?, `Preco` = ?, `Fornecedor` = ?," +
            "`Status_Produto` = ?, `Descricao` = ? WHERE `Id_Produto` =	?";

        try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, produto.getNomeP());
            stm.setString(2, produto.getCategoria());
            stm.setDouble(3, produto.getPrecoF());
            stm.setString(4, "Esqueceram o atributo Implementar");
            stm.setString(5, produto.getStatus());
            stm.setString(6, produto.getDescricao());
            stm.setInt(7, produto.getIdProduto());
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }


    public void excluir(int idProduto)
    {
        String sqlDelete = "DELETE FROM `produto` WHERE`Id_Produto` = ?;";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idProduto);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }

    
    public Produto carregar(int idProduto)
    {
        Produto produto = new Produto();

		String sqlSelect = "SELECT * FROM produto WHERE Id_Produto = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idProduto);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					produto.setIdProduto(resultSet.getInt("Id_Produto"));
					produto.setNomeP(resultSet.getString("Nome_Produto"));
					produto.setCategoria(resultSet.getString("Nome_Categoria"));
					produto.setPrecoF(resultSet.getDouble("Preco"));
					//produto.setFornecedor(resultSet.getString("Fornecedor"));
					produto.setStatus(resultSet.getString("Status_Produto"));
					produto.setDescricao(resultSet.getString("Descricao"));
				}
				else 
				{
					produto.setIdProduto(-1);
				}
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			
		}
		catch (SQLException sqlException1) 
		{
			sqlException1.printStackTrace();
		}

		return produto;
    }
    public ArrayList<Produto>buscarProdutoCtg(int IdCategoria){
    	String sqlSelect ="SELECT * FROM produto WHERE Produto.Id_Categoria = ?";
    	ArrayList<Produto> lista = new ArrayList<>();
    	Produto produto = new Produto();
    	
    	try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, IdCategoria);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					
					produto.setIdProduto(resultSet.getInt("Id_Produto"));
					produto.setNomeP(resultSet.getString("Nome_Produto"));
					produto.setCategoria(resultSet.getString("Nome_Categoria"));
					produto.setPrecoF(resultSet.getDouble("Preco"));
					//produto.setFornecedor(resultSet.getString("Fornecedor"));
					produto.setStatus(resultSet.getString("Status_Produto"));
					produto.setDescricao(resultSet.getString("Descricao"));
				    lista.add(produto);
				}
				else 
				{
					produto.setIdProduto(-1);
				}
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			
		}
		catch (SQLException sqlException1) 
		{
			sqlException1.printStackTrace();
		}

		return lista;
	
    
    }
    public ArrayList<Produto>buscarProduto()
    {
    	String sqlSelect ="SELECT * FROM produto";
    	ArrayList<Produto> lista = new ArrayList<>();
    	Produto produto;
    	
    	try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{

			try (ResultSet resultSet = stm.executeQuery();)
			{
				while(resultSet.next())
				{
					produto = new Produto();
					produto.setIdProduto(resultSet.getInt("Id_Produto"));
					produto.setNomeP(resultSet.getString("Nome_Produto"));
					produto.setCategoria(resultSet.getString("Nome_Categoria"));
					produto.setPrecoF(resultSet.getDouble("Preco"));
					//produto.setFornecedor(resultSet.getString("Fornecedor"));
					produto.setStatus(resultSet.getString("Status_Produto"));
					produto.setDescricao(resultSet.getString("Descricao"));
				    lista.add(produto);
				}
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			
		}
		catch (SQLException sqlException1) 
		{
			sqlException1.printStackTrace();
		}

		return lista;
		
    }
    
}
