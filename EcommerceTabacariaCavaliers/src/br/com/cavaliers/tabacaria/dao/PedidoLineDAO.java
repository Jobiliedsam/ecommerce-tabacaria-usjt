package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.PedidoLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PedidoLineDAO 
{
    public int inserir(PedidoLine pedidoLine)
    {
        String sqlInsert = "INSERT INTO `pedido_line` (`Id_Pedido_Header`, `Id_Produto`, `Quantidade_Produto`, `Valor_Produto`, `Nome_Produto`, `Preco_Unitario`)" 
        + "VALUES (?, ?, ?, ?, ?, ?)";

        
        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlInsert);)
        {
            stm.setInt(1, pedidoLine.getIdPedidoHeader());
            stm.setInt(2, pedidoLine.getIdProduto());
            stm.setInt(3, pedidoLine.getQuantidaeProduto());
            stm.setDouble(4, pedidoLine.getValorProduto());
            stm.setString(5, pedidoLine.getNomeDoProduto());
            stm.setDouble(6, pedidoLine.getPrecoUnitario());
            stm.execute();

            String sqlQuery = "SELECT LAST_INSERT_ID()";

            try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
                    ResultSet resultSet = stmQuery.executeQuery();)
            {
                if(resultSet.next())
                {
                    pedidoLine.setIdPedioLine(resultSet.getInt(1));
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
        
        return pedidoLine.getIdPedioLine();
    }

    public void atualizar(PedidoLine pedidoLine)
    {
        String sqlUpdate = "UPDATE `pedido_line` SET `Quantidade_Produto` = ?, `Valor_Produto` = ? WHERE `Id_Pedido_Line` = ?";

        try (Connection connection = new ConnectionFactory().obterConexao();
                PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
        {
            stm.setInt(1, pedidoLine.getQuantidaeProduto());
            stm.setDouble(2, pedidoLine.getValorProduto());
            stm.setInt(3, pedidoLine.getIdPedioLine());
            stm.execute();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void excluir(int idPedidoLine)
    {
        String sqlDelete = "DELETE FROM `pedido_line` WHERE Id_Pedido_Line = ";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idPedidoLine);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }

    public PedidoLine carregar(int idPedidoLine)
    {
        PedidoLine pedidoLine = new PedidoLine();

		String sqlSelect = "SELECT * FROM pedido_line WHERE Id_Pedido_Line = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idPedidoLine);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					pedidoLine.setIdPedioLine(resultSet.getInt("Id_Pedido_Line"));
					pedidoLine.setIdPedidoHeader(resultSet.getInt("Id_Pedido_Header"));
					pedidoLine.setIdProduto(resultSet.getInt("Id_Produto"));
					pedidoLine.setQuantidaeProduto(resultSet.getInt("Quantidade_Produto"));
					pedidoLine.setValorProduto(resultSet.getDouble("Valor_Produto"));
					pedidoLine.setNomeDoProduto(resultSet.getString("Nome_Produto"));
					pedidoLine.setPrecoUnitario(resultSet.getDouble("Preco_Unitario"));
				}
				else 
				{
					pedidoLine.setIdPedioLine(-1);
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

		return pedidoLine;
    }
}
