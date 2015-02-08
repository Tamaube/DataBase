package outils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class Tri
{
	public static ArrayList<ArrayList<String>> triRes(ResultSet res)
	{
		ResultSetMetaData rsmd;
		ArrayList<ArrayList<String>> tabRes = new ArrayList<ArrayList<String>>();
		try
		{
			rsmd = res.getMetaData();
			tabRes.add(new ArrayList<String>());
			for(int i = 0; i < rsmd.getColumnCount(); i++)
				tabRes.get(0).add(rsmd.getColumnName(i));
			ConnexionJDBC.getResEnCollection(res);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tabRes;
	}
}
