package Cryptanalyse;

import java.util.ArrayList;
import java.util.List;

public class Noeud_Racine {

	public static void procedure_racine(String crypte,int hash) {
		// estimation des clés possibles ( de 1 a 25 )
		List<Integer> cles = new ArrayList<Integer>();
		for(int i=1;i<=25;i++) cles.add(i);
		
		// estimation de nombre de noeuds travailleurs ( dans cet exemple 3 )
		int travailleurs = 3;
		
		// estimation d'intervale de clés par noeuds
		int t = cles.size() / travailleurs;
		
		// pour chaque noeud travailleur on va envoyer un intreval de clés de cette taille + texte haché
		for (int i=0;i<travailleurs;i++) {
			int min = 8*i;
			int max = 8*(i+1);
			// pour chaque valeur entre min et max on rempli chaque noeud
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int j=min;j<max;j++) {
				l.add(j);
			}
			Noeud_Travailleur n = new Noeud_Travailleur("N"+(i+1),crypte,l,hash);
			// on demarre le thread
			n.start();
		}
		
	}
	
	public static void main(String[] args) {
		String txt = "helloworld";
		int hashtxt = txt.hashCode();
		String txtc = Chiffrement_Cesar.chiffrer(txt,15);
		procedure_racine(txtc,hashtxt);
	}
}
