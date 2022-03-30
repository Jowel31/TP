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

	public final static int AGEMAX    = 15;
	public final static int AGEMATURE = 2;

	private double facteurCroissanceAntilope;
	
	
	public Antilope( double facteurCroissanceAntilope ) {
		
		super(facteurCroissanceAntilope, AGEMATURE, AGEMAX);
		this.facteurCroissanceAntilope = facteurCroissanceAntilope;
		
		setProie(true); setPredateur(false);
		
	}
	
	@Override
	public Animal accoucher() {
		return new Antilope(facteurCroissanceAntilope);

	}
	
}