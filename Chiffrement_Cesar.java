package Cryptanalyse;

public class Chiffrement_Cesar {
	
	public static final char[] alphabet = 
		{'A','B','C','D','E','F','G','H','I','J','K','L','M',
		'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
	protected static char[] texte_code = new char[26]; 
	protected static char[] texte_clair = new char[26]; 
	
	
	public static String chiffrer(String mot,int n) {
		String nvmot = "";
		// pour chaque lettre du chiffre , on cherche sa position dans l alphabet
		mot = mot.toUpperCase();
		char[] mots = mot.toCharArray();
		for ( char l : mots ) {
		int p = 0;
		for(int i=0;i<26;i++) {
			if (alphabet[i]==l) {
				p = i;
			}
		}
		// on remplace la lettre par la nouvelle lettre + n positions
		nvmot = nvmot + alphabet[(p+n)%26];
		}
		nvmot = nvmot.toLowerCase();
		return nvmot;
	}
	
	public static String dechiffrer(String mot,int n) {
		String nvmot = "";
		// pour chaque lettre du chiffre , on cherche sa position dans l alphabet
		mot = mot.toUpperCase();
		char[] mots = mot.toCharArray();
		for ( char l : mots ) {
		int p = 0;
		for(int i=0;i<26;i++) {
			if (alphabet[i]==l) {
				p = i;
			}
		}
		// on remplace la lettre par la nouvelle lettre + n positions
		nvmot = nvmot + alphabet[(p-n+26)%26];
		}
		nvmot = nvmot.toLowerCase();
		return nvmot;
	}
	
	public static void main(String[] args) {
		System.out.println(chiffrer("hello world",2));
		System.out.println(dechiffrer("nctcetchv",2));
	}

}
