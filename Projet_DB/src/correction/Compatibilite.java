package correction;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class Compatibilite {
	//Compatibilite sur 90 points 
	public static int verifierCorrespondance(ArrayList<ArrayList<Object>> resultatProfTrier, ArrayList<ArrayList<Object>> resultatEleveTrier){
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
	
	public static int verifierNombreColonneNombreLigne(ResultSetMetaData rsmdProf, ResultSetMetaData rsmdEleve) throws SQLException
	{
		int score = 0;
		if(rsmdProf.getColumnCount() ==  rsmdEleve.getColumnCount()){
			
		}
		
		
		return score;
	}
}
