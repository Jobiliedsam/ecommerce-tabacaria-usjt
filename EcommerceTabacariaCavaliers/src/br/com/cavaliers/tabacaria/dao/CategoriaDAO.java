package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO 
{
    public int inserir(Categoria categoria)
    {
        String sqlInsert = "INSERT INTO `categoria` (`Nome_Categoria`, `Status_Categoria`, `Descricao`)" +
            "VALUES (?, ?, ?)";

        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlInsert);)
        {
            stm.setString(1, categoria.getCategoria());
            stm.setString(2, categoria.getStatus());
            stm.setString(3, categoria.getDescricao());
            stm.execute();
        
			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					categoria.setIdCategoria(resultSet.getInt(1));
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

        return categoria.getIdCategoria();
    }


    public void atualizar(Categoria categoria)
    {
        String sqlUpdate = "UPDATE `categoria` SET `Nome_Categoria` = ?, `Status_Categoria` = ?," +
            "`Descricao` = ? WHERE `Id_Categoria` = ?";

        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
        {
            
            stm.setString(1, categoria.getCategoria());
            stm.setString(2, categoria.getStatus());
            stm.setString(3, categoria.getDescricao());
            stm.setInt(4, categoria.getIdCategoria());
            stm.execute();
        }
        catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }


    public void excluir(int idCategoria)
    {
        String sqlDelete = "DELETE FROM categoria WHERE Id_Categoria = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idCategoria);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }


    public Categoria carregar(int idCategoria)
    {
        Categoria categoria = new Categoria();

		String sqlSelect = "SELECT * FROM categoria WHERE Id_Categoria = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idCategoria);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
                    categoria.setIdCategoria(resultSet.getInt("Id_Categoria"));
                    categoria.setCategoria(resultSet.getString("Nome_Categoria"));
					categoria.setStatus(resultSet.getString("Status_Categoria"));
					categoria.setDescricao(resultSet.getString("Descricao"));
					
				}
				else 
				{
                    categoria.setIdCategoria(-1);
                    
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

		return categoria;
    }

}
