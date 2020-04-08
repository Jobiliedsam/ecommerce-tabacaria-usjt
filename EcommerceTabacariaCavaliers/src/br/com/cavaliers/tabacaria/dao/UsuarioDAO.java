package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	public int inserir(Usuario usuario)
    {
        String sqlInsert = "INSERT INTO `usuario` (`Email`, `Password`)" +
        "VALUES (?, ?)";

        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlInsert);)
        {
            stm.setString(1, usuario.getEmail());
            stm.setString(2, usuario.getPassword());
            stm.execute();
        
			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					usuario.setId(resultSet.getInt(1));
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

        return usuario.getId();
    }


    public void atualizar(Usuario usuario)
    {
        String sqlUpdate = "UPDATE `usuario` SET `Email` = ?, `Email` = ?," +
            "WHERE `Id` = ?";

        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
        {
            
        	stm.setString(1, usuario.getEmail());
            stm.setString(2, usuario.getPassword());
            stm.setInt(3, usuario.getId());
            stm.execute();
            
        }
        catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }


    public void excluir(int idUsuario)
    {
        String sqlDelete = "DELETE FROM categoria WHERE Id = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idUsuario);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }


    public Usuario carregar(int idUsuario)
    {
        Usuario usuario = new Usuario();

		String sqlSelect = "SELECT * FROM categoria WHERE Id = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idUsuario);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
                    usuario.setId(resultSet.getInt("Id"));
                    usuario.setEmail(resultSet.getString("Email"));
					usuario.setPassword(resultSet.getString("Password"));
					
				}
				else 
				{
                    usuario.setId(-1);
                    
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

		return usuario;
    }
    public boolean result = false;
    public boolean verificausuario(String email, String Password ) {
    	
    	String sql = "";
    	Connection connection = null;
		try {
			connection = new ConnectionFactory().obterConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	//i
    	sql += "select Id From usuario ";
    	sql += "where email = "+"'"+ email +"'";
    	sql += "and password = "+"'"+ Password +"'";
    	
    	try {
    		PreparedStatement stm = connection.prepareStatement(sql);
    		ResultSet resultSet = stm.executeQuery(sql);
    		if(resultSet.next()) {
    			result = true;
    		}
    	}catch (Exception e) {
    		
    	}
    	
      return result;
	}

}




