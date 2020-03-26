package br.com.cavaliers.tabacaria.dao;

import br.com.cavaliers.tabacaria.model.PedidoHeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoHeaderDAO 
{
    public int inserir(PedidoHeader pedidoHeader)
    {
        String sqlInsert = "INSERT INTO `pedido_header` (`Id_Cliente`, `Nome_Cliente`, `Quantidade_Total`, `Valor_Total`)"  +
            "VALUES (?, ?, ?, ?)";

        
        try (Connection connection = new ConnectionFactory().obterConexao();
            PreparedStatement stm = connection.prepareStatement(sqlInsert);)
        {
            stm.setInt(1, pedidoHeader.getIdCliente());
            stm.setString(2, pedidoHeader.getNomeCliente());
            stm.setInt(3, pedidoHeader.getQtdItens());
            stm.setDouble(4, pedidoHeader.getValorTotal());
            stm.execute();

            String sqlQuery = "SELECT LAST_INSERT_ID()";

            try (PreparedStatement stmQuery = connection.prepareStatement(sqlQuery);
                    ResultSet resultSet = stmQuery.executeQuery();)
            {
                if(resultSet.next())
                {
                    pedidoHeader.setIdPedido(resultSet.getInt(1));
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
        
        return pedidoHeader.getIdPedido();
    }

    public void atualizar(PedidoHeader pedidoHeader)
    {
        String sqlUpdate = "UPDATE `pedido_header` SET  `Quantidade_Total` = ?,  `Valor_Total` = ? WHERE `Id_Pedido` = ?";

        try (Connection connection = new ConnectionFactory().obterConexao();
                PreparedStatement stm = connection.prepareStatement(sqlUpdate);)
        {
            stm.setInt(1, pedidoHeader.getQtdItens());
            stm.setDouble(2, pedidoHeader.getValorTotal());
            stm.setInt(3, pedidoHeader.getIdPedido());
            stm.execute();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void excluir(int idPedido)
    {
        String sqlDelete = "DELETE FROM `pedido_header` WHERE `Id_Pedido` = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, idPedido);
			stm.execute();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
    }

    public PedidoHeader carregar(int idPedido)
    {
        PedidoHeader pedidoHeader = new PedidoHeader();

		String sqlSelect = "SELECT * FROM pedido_header WHERE Id_Pedido = ?";

		try (Connection connection = new ConnectionFactory().obterConexao();
				PreparedStatement stm = connection.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, idPedido);

			try (ResultSet resultSet = stm.executeQuery();)
			{
				if (resultSet.next())
				{
					pedidoHeader.setIdPedido(resultSet.getInt("Id_Pedido"));
					pedidoHeader.setIdCliente(resultSet.getInt("Id_Cliente"));
					pedidoHeader.setDataHoraCriacao(resultSet.getDate("Data_Hora"));
					pedidoHeader.setNomeCliente(resultSet.getString("Nome_Cliente"));
					pedidoHeader.setQtdItens(resultSet.getInt("Quantidade_Total"));
					pedidoHeader.setValorTotal(resultSet.getDouble("Valor_Total"));
				}
				else 
				{
					pedidoHeader.setIdPedido(-1);
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

		return pedidoHeader;
    }
}
