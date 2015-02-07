package correction;

import java.util.Collection;

public class Compatibilite {
	//Compatibilite sur 90 points 
	public static int verifierCorrespondance(Collection<Collection<Object>> resultatProfTrier, Collection<Collection<Object>> resultatEleveTrier){
		int score = 0;
		int compatibilite = 0;
		int cpt=0;
		int cpt2 = 0;
		while(cpt< resultatProfTrier.size() && cpt<resultatEleveTrier.size()){ 
			cpt2 = 0;
			Collection<Object> ligneResProf = resultatProfTrier.iterator().next();
			Collection<Object> ligneResEleve = resultatEleveTrier.iterator().next();
			while (cpt2< ligneResProf.size() && cpt2 < ligneResEleve.size())
			{
				Object elmtLigneProf = ligneResProf.iterator().next();
			}
			
			cpt++;
		}
		return score;
	}
}
