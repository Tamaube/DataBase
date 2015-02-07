package main;
import java.sql.*;
import java.util.ArrayList;

import outils.*;

public class CorrectionRequetes
{
	public static void main(String args[])
	{
		try
		{
			if(args.length != 3)
				throw(new IllegalArgumentException());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Usage : " + args[0] + " <" + args[1] + "> <" + args[2] + ">");
		}
				
		Connection co = ConnexionJDBC.openConnection(ConnexionJDBC.URL);
		
		
		ArrayList<String> ReqEleve = LecteurFichier.read(args[1]);
		ArrayList<String> ReqCor = LecteurFichier.read(args[2]);
	}
}
