package main;
import java.sql.ResultSet;
import java.util.ArrayList;

import correction.Compatibilite;
import outils.*;

public class CorrectionRequetes
{
	
	public static int corrigerUneRequete(String requeteProf, String requeteEleve, ConnexionJDBC co)
	{
		int score = 0;
		Compatibilite comp = new Compatibilite(co);
		ResultSet rsProf = co.executerSelect(requeteProf);
		ResultSet rsEleve = co.executerSelect(requeteEleve);
		if(comp.verifierNombreColonneNombreLigne(rsProf, rsEleve) && 
			comp.orderbyOK(requeteProf, requeteEleve))
		{
			ArrayList<ArrayList<String>> resultatEleveTrier = Tri.triRes(rsEleve);
			ArrayList<ArrayList<String>> resultatProfTrier = Tri.triRes(rsProf);
			score = comp.verifierCorrespondance(resultatProfTrier, resultatEleveTrier);
		}
		return score;
		
	}
	public static void main(String args[])
	{
		if(args.length != 2)
		{
			System.out.println("Usage : CorrectionRequetes.java <chemin_fichier_eleve> <chemin_fichier_correction>");
			System.exit(0);
		}
		
		ConnexionJDBC co = new ConnexionJDBC();
		co.openConnection();
		
		ArrayList<String> ReqEleve = LecteurFichier.read(args[0]);
		ArrayList<String> ReqCor = LecteurFichier.read(args[0]);
		
		int score = 0;
		
		int i=0; 
		while(i<ReqCor.size() && i<ReqEleve.size()) 
		{
			score = score + CorrectionRequetes.corrigerUneRequete(ReqCor.get(i), ReqCor.get(i), co);
			i++;
		}
		
		score = score/ ReqCor.size();
		System.out.println("Note: " + score + "/100");
		
		co.closeConnection();
	}
}
