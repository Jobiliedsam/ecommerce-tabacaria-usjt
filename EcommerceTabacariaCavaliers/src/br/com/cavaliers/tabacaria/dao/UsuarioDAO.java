package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	public int inserir(Usuario usuario)
    {
        String sqlInsert = "INSERT INTO `usuario` (`Email`, `Password`,`Tipo`)" +
        "VALUES (?, ?,'Cliente')";

		try (Connection connection = ConnectionFactory.obterConexao();
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

        try (Connection connection = ConnectionFactory.obterConexao();
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
        String sqlDelete = "DELETE FROM usuario WHERE Id_Uuario = ?";

		try (Connection connection = ConnectionFactory.obterConexao();
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

		String sqlSelect = "SELECT * FROM usuario WHERE Id = ?";

		try (Connection connection = ConnectionFactory.obterConexao();
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
    
    
    public ArrayList<Usuario> buscarUsuario()
    {
    	String sqlSelect ="SELECT email FROM Usuario";
    	ArrayList<Usuario> lista = new ArrayList<>();
    	Usuario usuario;


		try (Connection connection = ConnectionFactory.obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			try (ResultSet resultSet = stm.executeQuery();)
			{
				while (resultSet.next())
				{
					usuario = new Usuario();
					usuario.setId(resultSet.getInt("Id"));
                    usuario.setEmail(resultSet.getString("Email"));
                    usuario.setPassword(resultSet.getString("Password"));
					lista.add(usuario);
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
    
    
    public ArrayList<Usuario> buscarUsuario(String chave)
    {
    	String sqlSelect = "SELECT id, email FROM categoria WHERE UPPER (email) LIKE ?";
    	ArrayList<Usuario> lista = new ArrayList<>();
    	Usuario usuario;


		try (Connection connection = ConnectionFactory.obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);){
		        stm.setString(1, "%" + chave.toUpperCase() + "%");		
			try (ResultSet resultSet = stm.executeQuery();)
			{
				while (resultSet.next())
				{
					usuario = new Usuario();
					usuario.setId(resultSet.getInt("Id"));
                    usuario.setEmail(resultSet.getString("Email"));
                    usuario.setPassword(resultSet.getString("Password"));
					lista.add(usuario);
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


	public boolean validar(Usuario usuario) 
	{
		String sqlSelect = "SELECT Email, Password, Tipo FROM usuario "
				+ " WHERE Email = ? and Password = ?";
		try 
		{
			Connection connection = ConnectionFactory.obterConexao();
			
			try(PreparedStatement stm = connection.prepareStatement(sqlSelect))
			{
				stm.setString(1, usuario.getEmail());
				stm.setString(2, usuario.getPassword());
				
				try(ResultSet rs = stm.executeQuery())
				{
					if(rs.next()) 
					{
						usuario.setTipo(rs.getString("Tipo"));
						return true;
					}
					else return false;		
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		catch (SQLException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}	
}




