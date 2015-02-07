package correction;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import outils.ConnexionJDBC;


public class Compatibilite {
	
	private ConnexionJDBC co;
	
	public Compatibilite(ConnexionJDBC co){
		this.co =co;
	}
	
	//Compatibilite sur 90 points 
	public int verifierCorrespondance(ArrayList<ArrayList<String>> resultatProfTrier, ArrayList<ArrayList<String>> resultatEleveTrier){
		int score = 0;
		int compatibilite = 0;
		int cpt=0;
		int cpt2 = 0;

		while(cpt< resultatProfTrier.size() && cpt<resultatEleveTrier.size()){ 
			cpt2 = 0;
			
			
			while (cpt2< (resultatProfTrier.get(cpt)).size() && cpt2 < resultatEleveTrier.get(cpt).size())
			{
				Object elmtProf = resultatProfTrier.get(cpt).get(cpt2);
				Object elmtEleve = resultatEleveTrier.get(cpt).get(cpt2);
	
				
				if(elmtProf == elmtEleve)
				{
					compatibilite ++;
				}
			}
			
			cpt++;
		}
		score= (compatibilite / resultatProfTrier.get(0).size()) * 90;
		return score;
	}
	
	public boolean verifierNombreColonneNombreLigne(ResultSet rsProf, ResultSet rsEleve)
	{
		boolean score = false;
		try
		{
			ResultSetMetaData rsmdProf = rsProf.getMetaData();
			ResultSetMetaData rsmdEleve = rsEleve.getMetaData();
			score = (rsmdProf.getColumnCount() ==  rsmdEleve.getColumnCount());
			ArrayList<ArrayList<String>> resultatProf = this.co.getResEnCollection(rsProf);
			ArrayList<ArrayList<String>> resultatEleve = this.co.getResEnCollection(rsEleve);
			
			score = score && (resultatProf.size() == resultatEleve.size());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return score;
	}
}
