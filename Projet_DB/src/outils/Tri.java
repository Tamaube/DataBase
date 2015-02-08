package outils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import main.*;


public class Tri
{
	@SuppressWarnings("unchecked")
	public static TabRes triRes(ResultSet res)
	{
		ResultSetMetaData rsmd;
		TabRes tabRes = new TabRes();
		try
		{
			rsmd = res.getMetaData();
			tabRes.add(new LigneRes());
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				tabRes.get(0).add(rsmd.getColumnName(i));
			ArrayList<ArrayList<String>> tmp = ConnexionJDBC.getResEnCollection(res);
			System.out.println("test : " +tmp.size() ); ////////////////////////////////////////////////////////////////////////////// ligne test
			for(int i = 0; i < tmp.size(); i++)
			{
				tabRes.add(new ArrayList<String>());
				for(int j = 0; j < tmp.get(i).size(); j++)
				{
					tabRes.get(i+1).add(tmp.get(i).get(j));
				}
			}
			Collections.sort((ArrayList)tabRes);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tabRes;
	}
}
