// Fichier :     Antilope.java
// Creation:     
// Auteurs :     
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Cree pour le cours IFT1025 H22
//


class Antilope extends Animal {

	private final static int AGE_MAX = 15;
	private final static int AGE_MATURE = 2;

	public Antilope( double facteurCroissanceAntilopes ) {
		
		super (facteurCroissanceAntilopes);
		super.setProie(true);
		super.setPredateur(false);
	}
	
}