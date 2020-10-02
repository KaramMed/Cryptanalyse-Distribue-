package Cryptanalyse;

import java.util.ArrayList;


public class Noeud_Travailleur extends Thread{
	
	    String nom;
		private String crypte;
		private ArrayList<Integer> cles;
		private int hash;
		
		public Noeud_Travailleur(String nom,String chiffre,ArrayList<Integer> cles,int h) {
			// on initialise avec une liste de clés et texte chiffré
			this.nom = nom;
			crypte = chiffre;
			this.cles = cles;
			hash = h;
		}
		
		public void run() {
			// pour chaque clé on teste le decryptage
			for ( int cle : cles ) {
				String decrypte = Chiffrement_Cesar.dechiffrer(crypte,cle);
				// on hache le decryptage pour comparer
				System.out.println(" the node "+nom+" is trying the key "+cle);
				if (decrypte.hashCode() == hash) {
					// on renvoie message de confirmation 
					System.out.println(" Confirmation of the node "+nom+" : "+decrypte); 
				}
			}
		}
	
}
