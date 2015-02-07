package main;
import java.sql.*;
import java.util.ArrayList;

import outils.*;

public class CorrectionRequetes
{
	public static void main(String args[])
	{
		if(args.length != 2)
		{
			throw(new IllegalArgumentException());
			System.out.println("Usage : CorrectionRequetes.java <chemin_fichier_eleve> <chemin_fichier_correction>");
			System.exit(0);
		}
		
		Connection co = ConnexionJDBC.openConnection(ConnexionJDBC.URL);
		
		
		ArrayList<String> ReqEleve = LecteurFichier.read(args[0]);
		ArrayList<String> ReqCor = LecteurFichier.read(args[0]);
	}
}
