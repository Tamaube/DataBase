package outils;

import java.sql.*;
import java.util.ArrayList;

public class ConnexionJDBC {
	private Connection co;

	public void openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co = DriverManager
					.getConnection("jdbc:oracle:thin:elescar/patate$23@oracle.iut-orsay.fr:1521:etudom");
		} catch (ClassNotFoundException e) {
			System.out.println("il manque le driver oracle");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("impossible de se connecter ");
			System.exit(1);
		}
	}

	public ResultSet executerSelect(String requete) {
		Statement monInstruction;
		try {

			monInstruction = this.co.createStatement();
			ResultSet monresultat = monInstruction.executeQuery(requete);
			System.out.println(" ");
			System.out.println();
			monInstruction.close();

			return monresultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<ArrayList<String>> getResEnCollection(
			ResultSet monresultat) {
		ArrayList<ArrayList<String>> toutleresultat = new ArrayList<ArrayList<String>>();
		try {
			ResultSetMetaData rsmd = monresultat.getMetaData();

			while (monresultat.next()) {
				ArrayList<String> ligne = new ArrayList<String>();
				for (int j = 1; j <= rsmd.getColumnCount(); j++) {

					ligne.add(monresultat.getObject(j) + "");

				}
				toutleresultat.add(ligne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toutleresultat;
	}

	public void closeConnection() {
		try {
			co.close();
			System.out.println("Connexion fermée!");
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}
	}
}