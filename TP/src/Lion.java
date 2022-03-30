// Fichier :     Lion.java
// Creation:     
// Auteurs :
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Cree pour le cours IFT1025 H22
//


class Lion extends Animal {
	
	private final static int AGE_MAX = 50;
	private final static int AGE_MATURE = 5;
	
	public Lion( double facteurCroissanceLions ) {
		
		super (facteurCroissanceLions);
		super.setPredateur(true);
		super.setProie(false);
	}
	
}