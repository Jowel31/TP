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
	
	
	public void vieillir(); {// animal is getting one year older
		
		this.age += 1;
		
	}
	
    public void manger(); {// animal eats
    	
    	if (this.estPredateur()) {
    		
    		for (Animal animal : individus) {

    			if (animal.estProie()) {
    				
    				animal.mourir();
    			}
			}
    	}
    }

    public Animal accoucher(); {// animal delivers
    	
    	//add un animal dans la liste d'individus?
    }
    
    public void mourir() {// animal dies
    	this.estVivant() = false
    }
    
    public boolean estVivant() {// animal is alive
    	return true
    }
    
    public boolean estMature() {// animal is mature
    	return true
    }
    
    public void setProie( boolean proie ) {// set animal mode to prey
    	this.proie = proie;
    }
    
    public boolean estProie() {// animal is a prey
    	if(this.proie)//if true return true?
    		return true;
    	else
    		return false;
    }
    
    public void setPredateur( boolean predateur ) {// set animal mode to predator
    	this.predateur = predateur;
    }
    
    public boolean estPredateur() {// animal is a predator
    	if (this.predateur)
    		return true;
    	else
    		return false;
    }
    
    public double getMasse() {// get animal's mass
    	return this.masse
    }
    public void setMasse( double masse ) {// set animal's mass
    	this.masse = masse;
    }
    
    public void setAge( int age ) {// set animal's age
    	this.age = age;
    }
    
    public int getAge() {// get animal's age
    	return this.age;
    }
    
    public int getAgeMax() {// get animal's maximum age
    	return this.ageMax;
    }
    
    public int getAgeMature() {// get animal's mature age
    	return this.ageMature;
    }
	
}