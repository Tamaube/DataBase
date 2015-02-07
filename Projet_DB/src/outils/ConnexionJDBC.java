package outils;

import java.sql.*;
public class ConnexionJDBC
{
	public static final String URL = "jdbc:oracle:thin:elescar/patate$23@r2d2.etu.iut-orsay.fr:1521:etudom";
	
	public static Connection openConnection(String url)
	{
		Connection co=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co= DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		catch (SQLException e)
		{
			System.out.println("impossible de se connecter à l'url : "+url);
			System.exit(1);
		}
		return co;
	}

	public static void closeConnection(Connection co)
	{
		try
		{
			co.close();
			System.out.println("Connexion fermée!");
		}
		catch(SQLException e)
		{
			System.out.println("Impossible de fermer la connexion");
		}	
	}
}
