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
	
	int age;
	int masse;
	boolean estVivant;
	
	public Animal() {
		
		
		// L'animal prend vie et recoit un age initial et une masse initiale
		@Override
		public void naitre() {
			
			this.setAge(0);
			this.setMasse(10);
			this.estVivant = true;
		}
		
		
		// L'animal viellit d'un an
		@Override
		public void vieillir() {
			
			this.age += 1;
			
			if (this.age > this.AGEMAX) {
				this.mourir();
			}
<<<<<<< HEAD
    	}
    }
    
    @Override
    public Animal accoucher() {// animal delivers
    	
    	//add un animal dans la liste d'individus?
    }
    
    @Override
    public void mourir() {// animal dies
    	this.estVivant() = false
    }
    
    public boolean estVivant() {// animal is alive
    	return true;
    }
    
    @Override
    public boolean estMature() {// animal is mature
    	return true;
    }
    
    @Override
    public void setProie( boolean proie ) {// set animal mode to prey
    	this.proie = proie;
    }
    
    @Override
    public boolean estProie() {// animal is a prey
    	if(this.proie)//if true return true?
    		return true;
    	else
    		return false;
    }
    
    @Override
    public void setPredateur( boolean predateur ) {// set animal mode to predator
    	this.predateur = predateur;
    }
    
    @Override
    public boolean estPredateur() {// animal is a predator
    	if (this.predateur)
    		return true;
    	else
    		return false;
    }
    
    
    
    // setter, getter de la masse de l'animal
    
    @Override
    public void setMasse( double masse ) {// modifier la masse del'animal
    	this.masse = masse;
    }
    
    @Override
    public double getMasse() {// retourne la masse de l'animal
    	return this.masse;
    }
    
    
    // setter, getter de l'age de l'animal
    
    @Override
    public void setAge( int age ) {// modifier l'age de l'animal
    	this.age = age;
    }
    
    @Override
    public int getAge() {// retourne l'age de l'animal
    	return this.age;
    }
    
    
    // getters de l'age mature et de l'age maximum de l'animal
    
    @Override
    public int getAgeMature() {// retourne l'age de maturite de l'animal
    	return this.ageMature;
    }
    
    @Override
    public int getAgeMax() {// retourne l'age maximum de l'animal
    	return this.ageMax;
    }
=======
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
	    	
	    	this.estVivant = false;
	    }
	    
	    
	    // L'animal est vivant?
	    public boolean estVivant() {
	    	
	    	return this.estVivant;
	    }
	    
	    
	    // L'animal est mature?
	    @Override
	    public boolean estMature() {
	    	
	    	if (this.age >= this.ageMature) {
	    		return true;
	    		
	    	} else {
	    		return false;
	    	}
	    }
	    
	    
	    // Definir l'animal comme etant une proie
	    @Override
	    public void setProie( boolean proie ) {
	    	
	    	this.estProie = proie;
	    }
	    
	    
	    // L'animal est une proie?
	    @Override
	    public boolean estProie() {
	    	
	    	return this.estProie;
	    }
	    
	    
	    // Definir l'animal comme etant un predateur
	    @Override
	    public void setPredateur( boolean predateur ) {
	    	
	    	this.estPredateur = predateur;
	    }
	    
	    
	    // L'animal est un predateur?
	    @Override
	    public boolean estPredateur() {
	    	
	    	return this.estPredateur;
	    }
	    
	    
	    // setter, getter de la masse de l'animal
	    
	    @Override
	    public void setMasse( double masse ) {
	    	
	    	this.masse = masse;
	    }
	    
	    @Override
	    public double getMasse() {
	    	
	    	return this.masse;
	    }
	    
	    
	    // setter, getter de l'age de l'animal
	    
	    @Override
	    public void setAge( int age ) {
	    	
	    	this.age = age;
	    }
	    
	    @Override
	    public int getAge() {
	    	
	    	return this.age;
	    }
	    
	    
	    // getters de l'age mature et de l'age maximum de l'animal
	    
	    @Override
	    public int getAgeMature() {
	    	
	    	return this.ageMature;
	    }
	    
	    @Override
	    public int getAgeMax() {
	    	
	    	return this.AGEMAX;
	    }
	    
	}
>>>>>>> branch 'master' of https://github.com/Jowel31/TP.git
	
}