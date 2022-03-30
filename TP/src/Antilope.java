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
	
	// Constantes
	public final static int AGEMAX    = 15;
	public final static int AGEMATURE = 2;
	
	// Variables
	private double facteurCroissanceAntilope;
	
	
	// Constructeur
	public Antilope( double facteurCroissanceAntilope ) {
		
		super(facteurCroissanceAntilope, AGEMATURE, AGEMAX);
		
		this.facteurCroissanceAntilope = facteurCroissanceAntilope;
		
		// Une antilope est une proie donc n'est pas un predateur dans ce contexte
		setProie(true); setPredateur(false);
		
	}
	
	// Lorsque l'antilope accouche, elle cree un nouvel objet de type Antilope
	@Override
	public Animal accoucher() {
		return new Antilope(facteurCroissanceAntilope);

	}
	
}