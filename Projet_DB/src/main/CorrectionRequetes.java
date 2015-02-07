package main;
import java.util.ArrayList;

import outils.*;

public class CorrectionRequetes
{
	public static void main(String args[])
	{
		if(args.length != 2)
		{
			System.out.println("Usage : CorrectionRequetes.java <chemin_fichier_eleve> <chemin_fichier_correction>");
			System.exit(0);
		}
		
		ConnexionJDBC co = new ConnexionJDBC();
		
		
		ArrayList<String> ReqEleve = LecteurFichier.read(args[0]);
		ArrayList<String> ReqCor = LecteurFichier.read(args[0]);
	}
}
