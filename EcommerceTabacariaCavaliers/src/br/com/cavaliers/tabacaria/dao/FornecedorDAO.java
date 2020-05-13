package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Fornecedor;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList; 

public class FornecedorDAO {
	public int inserir (Fornecedor fornecedor) {
		String sqlInsert = "INSERT INTO fornecedor (Nome_Fornecedor, Cnpj, Telefone, Email, Descricao)	VALUES (?, ?, ?, ?, ?)";
		
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
	
	public void excluir(int idFornecedor) {
		
		String sqlDelete = "DELETE FROM fornecedor WHERE Id_Fornecedor = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idFornecedor);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

	}
	
	public Fornecedor carregar(int idFornecedor)
	{
		Fornecedor fornecedor = new Fornecedor();

		String sqlSelect = "SELECT * FROM fornecedor WHERE Id_Fornecedor = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idFornecedor);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					fornecedor.setIdFornecedor(resultSet.getInt("Id_Fornecedor"));
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
	
	public ArrayList<Fornecedor> listarFornecedores() {
		Fornecedor fornecedor;
		ArrayList<Fornecedor> lista = new ArrayList<>();
		String sqlSelect = "SELECT Id_Fornecedor, Nome_Fornecedor, Cnpj, Telefone, Email, Descricao FROM fornecedor";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					fornecedor = new Fornecedor();
					fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
					fornecedor.setNomeFornecedor(rs.getString("nomeFornecedor"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setContatoTelefone(rs.getString("contatoTelefone"));
					fornecedor.setContatoEmail(rs.getString("contatoEmail"));
					lista.add(fornecedor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Fornecedor> listarFornecedores(String chave) {
		Fornecedor fornecedor;
		ArrayList<Fornecedor> lista = new ArrayList<>();
		String sqlSelect = "SELECT Id_Fornecedor, Nome_Fornecedor, Cnpj, Telefone, Email, Descricao FROM fornecedor where upper(Nome_Fornecedor) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					fornecedor = new Fornecedor();
					fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
					fornecedor.setNomeFornecedor(rs.getString("nomeFornecedor"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setContatoTelefone(rs.getString("contatoTelefone"));
					fornecedor.setContatoEmail(rs.getString("contatoEmail"));
					lista.add(fornecedor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}

