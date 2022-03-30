// Fichier :     Antilope.java
// Creation:     30 mars 2022
// Auteurs :     Joel Villeneuve et Paul Loignon
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Cree pour le cours IFT1025 H22
//


class Antilope extends Animal {
	
	
	public final static int AGEMAX    = 15; // Age maximum avant la mort
	public final static int AGEMATURE = 2;	// Age minimum avant de pouvoir s'accoupler
	
	// Constructeur
	public Antilope( double facteurCroissanceAntilope ) {
		
		super(facteurCroissanceAntilope, AGEMATURE, AGEMAX); // On initialise l'animal	
		setProie(true); setPredateur(false);				 // Antilope est une proie
	}
	
	// Retourne un bebe Antilope
	@Override
	public Antilope accoucher() { return new Antilope(getFacteurCroissance()); }
	
	
}