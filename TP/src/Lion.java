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
	
	private double facteurCroissanceLion;
	public final static int AGEMAX = 50;
	public final static int AGEMATURE = 5;
	
	public Lion( double facteurCroissanceLion ) {
		
		super(facteurCroissanceLion, AGEMATURE, AGEMAX);
		
		this.facteurCroissanceLion = facteurCroissanceLion;
		setPredateur(true);
		setProie(false);
	}
	
	@Override
	public Animal accoucher() {
		return new Lion(facteurCroissanceLion);
	}
}
	
