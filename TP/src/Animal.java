// Fichier :     Animal.java
// Création:     
// Auteurs :      Paul Loignon
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Animal
    implements the Prey/Predator relationship

**/
 
    // TO BE COMPLETED //

public class Animal implements ProiePredateur {
	
	private int age;
	private double masse;
	private boolean estVivant;
	private double facteurCroissance;
	private int AGE_MAX;
	private int AGE_MATURE;
	private boolean estProie;
	private boolean estPredateur;
	
	
	public Animal(double facteurCroissance) {
	}
		
		// L'animal prend vie et recoit un age initial et une masse initiale
		@Override
		public void naitre() {
			
			setAge(0);
			setMasse(10);
			estVivant = true;
		}
		
		
		// L'animal viellit d'un an
		@Override
		public void vieillir() {
			
			age += 1;
			
			if (age > AGE_MAX) {
				mourir();
			}
			
			masse *= facteurCroissance;
		}
		
		
		// L'animal mange
		@Override
	    public void manger() {
	    	
	    	
	    }
	    
		
	    // L'animal donne naissance
	    @Override
	    public Animal accoucher() {
	    	
	    	if (this.estProie) {
	    		Antilope animal = new Antilope();
	    		
	    	} else {
	    		Lion animal = new Lion();
	    	}
	    	
	    	animal.naitre();
	    	
	    	return animal;
	    }
	    
	    
	    // L'animal meurt
	    @Override
	    public void mourir() {
	    	
	    	estVivant = false;
	    }
	    
	    
	    @Override
	    // L'animal est vivant?
	    public boolean estVivant() {
	    	
	    	return estVivant;
	    }
	    
	    
	    // L'animal est mature?
	    @Override
	    public boolean estMature() {
	    	
	    	return age >= AGE_MATURE;
	    }
	    
	    
	    // Definir l'animal comme etant une proie
	    @Override
	    public void setProie( boolean proie ) {
	    	
	    	estProie = proie;
	    }
	    
	    
	    // L'animal est une proie?
	    @Override
	    public boolean estProie() {
	    	
	    	return estProie;
	    }
	    
	    
	    // Definir l'animal comme etant un predateur
	    @Override
	    public void setPredateur( boolean predateur ) {
	    	
	    	estPredateur = predateur;
	    }
	    
	    
	    // L'animal est un predateur?
	    @Override
	    public boolean estPredateur() {
	    	
	    	return estPredateur;
	    }
	    
	    
	    // setter, getter de la masse de l'animal
	    
	    @Override
	    public void setMasse( double masse ) {
	    	
	    	this.masse = masse;
	    }
	    
	    @Override
	    public double getMasse() {
	    	
	    	return masse;
	    }
	    
	    
	    // setter, getter de l'age de l'animal
	    
	    @Override
	    public void setAge( int age ) {
	    	
	    	this.age = age;
	    }
	    
	    @Override
	    public int getAge() {
	    	
	    	return age;
	    }
	    
	    
	    // getters de l'age mature et de l'age maximum de l'animal
	    
	    @Override
	    public int getAgeMature() {
	    	
	    	return ageMature;
	    }
	    
	    @Override
	    public int getAgeMax() {
	    	
	    	return AGE_MAX;
	    }
	    
}
	
