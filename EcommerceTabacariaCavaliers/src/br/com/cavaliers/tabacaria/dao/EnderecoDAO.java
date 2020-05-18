package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    public int inserir(Endereco endereco)
    {
        String sqlInsert = "INSERT INTO `tabacaria`.`endereco`" + 
            "(`Id_Cliente`, `Endereco_Principal`, `Endereco_Secundario`, `CEP`, `Cidade`, `Estado`, `Complemento`)" +
            "Values (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlInsert);)
        {

            stm.setInt(1, endereco.getIdCliente());
            stm.setString(2, endereco.getEnderecoP());
            stm.setString(3, endereco.getEnderecoS());
            stm.setString(4, endereco.getCep());
            stm.setString(5, endereco.getCidade());
            stm.setString(6, endereco.getEstado());
            stm.setString(7, endereco.getComplemento());
            stm.execute();
        
			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
					ResultSet resultSet = stmQuery.executeQuery();)
			{
				if(resultSet.next())
				{
					endereco.setIdEndereco(resultSet.getInt(1));
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
        
        return endereco.getIdEndereco();
    }

    public void atualizar(Endereco endereco)
    {
        String sqlUpdate = "UPDATE `tabacaria`.`endereco` SET `Id_Endereco` = ?, " +
            "`Endereco_Principal` = ?, `Endereco_Secundario` = ?, `CEP` = ?, `Cidade` = ?, `Estado` = ?," +
            "`Complemento` = ?  WHERE `Id_Cliente` = ?;";

        
        try (Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
        {

            stm.setInt(1, endereco.getIdEndereco());
            stm.setString(2, endereco.getEnderecoP());
            stm.setString(3, endereco.getEnderecoS());
            stm.setString(4, endereco.getCep());
            stm.setString(5, endereco.getCidade());
            stm.setString(6, endereco.getEstado());
            stm.setString(7, endereco.getComplemento());
            stm.setInt(8, endereco.getIdCliente());

            stm.execute();
        }
        catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }

    public void excluir(int idCliente)
    {
        String sqlDelete = "DELETE FROM endereco WHERE Id_Cliente = ?";

		try (Connection connection = ConnectionFactory.obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idCliente);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }

    public Endereco carregar(int idCliente)
    {
        Endereco endereco = new Endereco();

		String sqlSelect = "SELECT * FROM endereco WHERE Id_Cliente = ?";

		try (Connection connection = ConnectionFactory.obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idCliente);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
                    endereco.setIdEndereco(resultSet.getInt("Id_Endereco"));
                    endereco.setIdCliente(resultSet.getInt("Id_Endereco"));
					endereco.setEnderecoP(resultSet.getString("Endereco_Principal"));
					endereco.setEnderecoS(resultSet.getString("Endereco_Secundario"));
					endereco.setCep(resultSet.getString("CEP"));
					endereco.setCidade(resultSet.getString("Cidade"));
					endereco.setEstado(resultSet.getString("Estado"));
					endereco.setComplemento(resultSet.getString("Complemento"));
				}
				else 
				{
                    endereco.setIdEndereco(-1);
                    endereco.setIdCliente(-1);
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

		return endereco;
    }

}
