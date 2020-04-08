package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Fornecedor;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class FornecedorDAO {
	public int inserir (Fornecedor fornecedor) {
		String sqlInsert = "INSERT INTO fornecedor" + 
				"(Nome_Fornecedor, Cnpj, Telefone, Email, Descricao"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlInsert);) {
			
			stm.setString(1, fornecedor.getNomeFornecedor());
			stm.setString(2, fornecedor.getCnpj());
			stm.setString(3, fornecedor.getContatoTelefone());
			stm.setString(4, fornecedor.getContatoEmail());
			stm.setString(5, fornecedor.getDescricao());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			
			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					fornecedor.setIdFornecedor(resultSet.getInt(1));
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
		
		return fornecedor.getIdFornecedor();
	}
	
	public void atualizar (Fornecedor fornecedor) {
		
		String sqlUpdate = "UPDATE `fornecedor` SET  `Nome_Fornecedor` = ?, `Cnpj` = ?, " +
				"`Telefone` = ?, `Email` = ?, `Descricao` = ?,";
		
		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, fornecedor.getNomeFornecedor());
			stm.setString(2, fornecedor.getCnpj());
			stm.setString(3, fornecedor.getContatoTelefone());
			stm.setString(4, fornecedor.getContatoEmail());
			stm.setString(5, fornecedor.getDescricao());
			stm.execute();
	   }
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		
		String sqlDelete = "DELETE FROM fornecedor WHERE Id_Fornecedor = ?";

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
	
	public Fornecedor carregar(int id)
	{
		Fornecedor fornecedor = new Fornecedor();

		String sqlSelect = "SELECT * FROM cliente WHERE Id_Fornecedor = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, id);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					fornecedor.setIdFornecedor(resultSet.getInt("Id_Cliente"));
					fornecedor.setNomeFornecedor(resultSet.getString("Nome_Fornecedor"));
					fornecedor.setCnpj(resultSet.getString("Cnpj"));
					fornecedor.setContatoTelefone(resultSet.getString("Telefone"));
					fornecedor.setContatoEmail(resultSet.getString("Email"));
					fornecedor.setDescricao(resultSet.getString("Descricao"));
				}
				else 
				{
					fornecedor.setIdFornecedor(-1);
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

		return fornecedor;
	}
}

