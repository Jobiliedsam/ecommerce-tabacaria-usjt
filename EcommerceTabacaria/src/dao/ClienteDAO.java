package dao;

import model.Cliente;
import java.sql.Date;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException; 
//import java.util.ArrayList;

public class ClienteDAO {
	
	public int inserir(Cliente cliente)
	{		
		String sqlInsert = "INSERT INTO cliente " +
			"(Nome_Completo, Telefone, Celular, CPF, Genero, Tipo, Email, Data_Nascimeto)" +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = new ConnectionFactory().obterConexao();
			PreparedStatement stm = connection.prepareStatement(sqlInsert);)
		{
			stm.setString(1, cliente.getNomeCompleto());
			stm.setString(2, cliente.getTelefone());
			stm.setString(3, cliente.getCelular());
			stm.setString(4, cliente.getCpfCnpj());
			stm.setString(5, cliente.getGenero());
			stm.setString(6, cliente.getTipo());
			stm.setString(7, cliente.getEmail());
			stm.setDate(8, new Date(cliente.getDataDeNascimento().getTime()));
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					cliente.setIdCliente(resultSet.getInt(1));
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
		
		return cliente.getIdCliente();
	}

	
	public void atualizar(Cliente cliente)
	{
		String sqlUpdate = "UPDATE `cliente` SET  `Nome_Completo` = ?, `Telefone` = ?, " +
			"`Celular` = ?, `CPF` = ?, `Genero` = ?, `Tipo` = ?, `Email` = ?,`Data_Nascimeto` = ? " +
			"WHERE `Id_Cliente` = ? ";


		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, cliente.getNomeCompleto());
			stm.setString(2, cliente.getTelefone());
			stm.setString(3, cliente.getCelular());
			stm.setString(4, cliente.getCpfCnpj());
			stm.setString(5, cliente.getGenero());
			stm.setString(6, cliente.getTipo());
			stm.setString(7, cliente.getEmail());
			stm.setDate(8, new Date(cliente.getDataDeNascimento().getTime()));
			stm.setInt(9, cliente.getIdCliente());
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	
	public void excluir(int id)
	{
		String sqlDelete = "DELETE FROM cliente WHERE Id_Cliente = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, id);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

	}

	
	public Cliente carregar(int id)
	{
		Cliente cliente = new Cliente();

		String sqlSelect = "SELECT * FROM cliente WHERE Id_Cliente = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, id);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					cliente.setIdCliente(resultSet.getInt("Id_Cliente"));
					cliente.setNomeCompleto(resultSet.getString("Nome_Completo"));
					cliente.setTelefone(resultSet.getString("Telefone"));
					cliente.setCelular(resultSet.getString("Celular"));
					cliente.setCpfCnpj(resultSet.getString("CPF"));
					cliente.setGenero(resultSet.getString("Genero"));
					cliente.setTipo(resultSet.getString("Tiop"));
					cliente.setEmail(resultSet.getString("Email"));
					cliente.setDataDeNascimento(resultSet.getDate("Data_Nascimento"));
				}
				else 
				{
					cliente.setIdCliente(-1);
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

		return cliente;
	}
}
