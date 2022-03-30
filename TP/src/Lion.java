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
	
	// Constantes
	public final static int AGEMAX    = 50;
	public final static int AGEMATURE = 5;
	
	// Variables
	private double facteurCroissanceLion;
	
	
	// Constructeur
	public Lion( double facteurCroissanceLion ) {
		
		super(facteurCroissanceLion, AGEMATURE, AGEMAX);
		
		this.facteurCroissanceLion = facteurCroissanceLion;
		
		// Un lion est un predateur donc n'est pas une proie dans ce contexte
		setPredateur(true); setProie(false);
		
	}
	
	// Lorsque la lionne accouche, elle cree un nouvel objet de type Lion
	@Override
	public Animal accoucher() {	
		return new Lion(facteurCroissanceLion);
	
	}
	
}