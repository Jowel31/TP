// Fichier :     Lion.java
// Creation:     30 mars 2022
// Auteurs :	 Paul Loignon et Joel Villeneuve
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Cree pour le cours IFT1025 H22
//


class Lion extends Animal {
	
	
	public final static int AGEMAX    = 50; // Age maximum avant la mort
	public final static int AGEMATURE = 5;	// Age minimum pour s'accoupler
	
	// Constructeur
	public Lion( double facteurCroissanceLion ) {
		
		super(facteurCroissanceLion, AGEMATURE, AGEMAX); // On initialise l'animal
		setPredateur(true); setProie(false);             // Le lion est un predateur
	}
	
	// Retourne un bebe Lion
	@Override
	public Lion accoucher() { return new Lion(getFacteurCroissance()); }
	
}