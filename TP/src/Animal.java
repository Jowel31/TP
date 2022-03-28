// Fichier :     Animal.java
// Création:     
// Auteurs :      
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
	
	@Override
	public void naitre(); {// animal becomes alive
		
		this.setAge(0);
		this.setMasse(10);
		
		
		/*
		if (animal.estPredateur()) {
			
			nombreLions += 1;
		}
		
		else (animal.estProie()) {
			
			nombreAntilopes += 1;
		}*/
		
	}
	
	@Override
	public void vieillir(); {// animal is getting one year older
		
		this.age += 1;
		
	}
	
	@Override
    public void manger(); {// animal eats
    	
    	if (this.estPredateur()) {
    		
    		for (Animal animal : individus) {

    			if (animal.estProie()) {
    				
    				animal.mourir();
    			}
			}
    	}
    }
    
    @Override
    public Animal accoucher(); {// animal delivers
    	
    	//add un animal dans la liste d'individus?
    }
    
    @Override
    public void mourir() {// animal dies
    	this.estVivant() = false
    }
    
    public boolean estVivant() {// animal is alive
    	return true
    }
    
    @Override
    public boolean estMature() {// animal is mature
    	return true
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
	
}