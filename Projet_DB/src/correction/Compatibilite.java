package correction;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import main.TabRes;
import outils.ConnexionJDBC;


public class Compatibilite {
	
	private ConnexionJDBC co;
	
	public Compatibilite(ConnexionJDBC co){
		this.co =co;
	}
	
	//Compatibilite sur 100 points
	public int verifierCorrespondance(TabRes resultatProfTrier, TabRes resultatEleveTrier){
		int score = 0;
		int compatibilite = 0;
		int cpt=0;
		int cpt2 = 0;
		
		System.out.println("taille prof: " + resultatProfTrier.size() );
		System.out.println(resultatProfTrier);

		while(cpt< resultatProfTrier.size() && cpt<resultatEleveTrier.size()){ 
			cpt2 = 0;
			System.out.println("1er while: " + resultatProfTrier.get(cpt).size());
			
			while (cpt2< (resultatProfTrier.get(cpt)).size() && cpt2 < resultatEleveTrier.get(cpt).size())
			{
				String elmtProf = resultatProfTrier.get(cpt).get(cpt2);
				String elmtEleve = resultatEleveTrier.get(cpt).get(cpt2);
				
				System.out.println("elmtProf " + elmtProf + " elmtEleve " + elmtEleve);
				if(elmtProf == elmtEleve)
				{
					compatibilite ++;
				}
				
				cpt2++;
			}
			
			cpt++;
		}
		System.out.println(resultatProfTrier);
		System.out.println(resultatProfTrier.get(0).size());
		//score= (compatibilite / resultatProfTrier.get(0).size()) * 100;
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
//			ArrayList<ArrayList<String>> resultatProf = this.co.getResEnCollection(rsProf);
//			ArrayList<ArrayList<String>> resultatEleve = this.co.getResEnCollection(rsEleve);
//			
//			score = score && (resultatProf.size() == resultatEleve.size());
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return score;
	}
	
	public boolean orderbyOK(String req1, String req2)
	{
		boolean ob1 = false, ob2 = false;
		if(req1.toLowerCase().contains("order by"))
		{
			ob1 = true;
			System.out.println("test");
		}
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
