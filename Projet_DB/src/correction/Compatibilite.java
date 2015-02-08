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
	
	public boolean orderbyOK(String req1, String req2)
	{
		boolean ob1 = false, ob2 = false;
		if(req1.toLowerCase().contains("order by"))
			ob1 = true;
		if(req2.toLowerCase().contains("order by"))
			ob2 = true;
		if(ob1 == ob2 == false)
			return true;
		else if(ob1 == ob2 == true)
		{
			String sub1, sub2;
			sub1 = req1.toLowerCase().substring(req1.indexOf("order by") + "order by".length());
			sub1 = sub1.toLowerCase().substring(0, sub1.indexOf("\n"));
			sub2 = req2.substring(req2.indexOf("order by") + "order by".length());
			sub2 = sub2.substring(0, sub2.indexOf("\n"));
			return sub1.equals(sub2);
		}
		else
			return false;
	}
	
}
