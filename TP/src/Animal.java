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
		
		animal.getAge();
		animal.getMasse();
		animal.setAge(0);
		animal.setMasse(10);
		
		if (animal.estProie()) {
			
			nombreLions += 1;
		}
		
		else (animal.estProie()) {
			
			nombreAntilopes += 1;
		}
		
	}
	
	
	public void vieillir(); {// animal is getting one year older
		
		animal.setAge() += 1;
		
	}
	
	
    public void manger(); {// animal eats
    	
    	//aucune idee qoui faire//
    
    }

    public Animal accoucher(); {// animal delivers
    	
    }
    public void mourir(); // animal dies
    public boolean estVivant(); // animal is alive
    public boolean estMature(); // animal is mature
    
    public void setProie( boolean proie ) {// set animal mode to prey
    	this.proie = proie;
    }
    
    public boolean estProie() {// animal is a prey
    	if(this.proie)
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