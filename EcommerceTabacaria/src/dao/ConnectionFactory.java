package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection obterConexao() throws SQLException 
	{
		String servidor = "localhost";
		String porta = "3306";
		String database = "tabacaria";
		String usuario = "USJTCavaliers";
		String senha = "USJTCavaliers";

		String stringConnection = "jdbc:mysql://" 
			+ servidor + ":" 
			+ porta + "/" 
			+ database + "?useTimezone=true&serverTimezone=UTC&user=" 
			+ usuario  + "&password=" 
			+ senha + "&useSSL=false"; // + "&useTimezone=true&serverTimezone=America/Sao_Paulo";

		try 
		{
			return DriverManager.getConnection(stringConnection);	
		}
		catch (SQLException sqlException)
		{
			throw new RuntimeException(sqlException);
		}
	}
}
