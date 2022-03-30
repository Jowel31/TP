// Fichier :     Animal.java
// Creation:     30 mars 2022
// Auteurs :     Paul Loignon
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Cree pour le cours IFT1025 H22
//


// La classe Animal implemente les methodes de l'interface ProiePredateur 
// pour representer le comportement general d'un animal.

// Abstraite, car l'instanciation d'un animal general n'a pas de sens. 
public abstract class Animal implements ProiePredateur {
	
	
	// Variables
	private int age;
	private int ageMature;
	private int ageMax;
	private double masse;
	private double facteurCroissance;
	private boolean estVivant;
	private boolean estProie;
	private boolean estPredateur;
	
	
	// Constructeur
	public Animal(double facteurCroissance, int ageMature, int ageMax) {
		
		naitre();
		
		// Association des attributs
		this.facteurCroissance = facteurCroissance;
		this.ageMature = ageMature;
		this.ageMax = ageMax;
		
	}
	
	
		// L'animal prend vie et recoit un age initial et une masse initiale
		@Override
		public void naitre() {
			
			setAge(0);
			setMasse(10);
			estVivant = true;
			
		}
		
		
		// L'animal viellit d'un an et meurt s'il depasse son age maximum.
		// La masse augmente aussi lors du vieillissement.
		@Override
		public void vieillir() {
			
			age += 1;
			
			if (age > ageMax) {
				mourir();
			}
			
			masse *= facteurCroissance;
			
		}
	    
	    
	    // L'animal meurt donc il n'est plus vivant
	    @Override
	    public void mourir() {
	    	estVivant = false;
	    	
	    }
	    
	    
	    // Retourne un booleen pour savoir si l'animal est vivant
	    @Override
	    public boolean estVivant() {
	    	return estVivant;
	    	
	    }
	    
	    
	    // Retourne un booleen pour savoir si l'animal est mature
	    @Override
	    public boolean estMature() {
	    	return age >= ageMature;
	    	
	    }
	    
	    
	    // Donne un attribut booleen qui definit si c'est une proie ou non
	    @Override
	    public void setProie( boolean proie ) {
	    	estProie = proie;
	    	
	    }
	    
	    
	    // Retourne un booleen pour savoir si l'animal est une proie
	    @Override
	    public boolean estProie() {
	    	return estProie;
	    	
	    }
	    
	    
	    // Donne un attribut booleen qui definit si c'est un predateur ou non
	    @Override
	    public void setPredateur( boolean predateur ) {
	    	estPredateur = predateur;
	    	
	    }
	    
	    
	    // Retourne un booleen pour savoir si l'animal est un predateur
	    @Override
	    public boolean estPredateur() {
	    	return estPredateur;
	    	
	    }
	    
	    
	    // Setter, Getter de la masse de l'animal
	    
	    @Override
	    public void setMasse( double masse ) {
	    	this.masse = masse;
	    	
	    }
	    
	    @Override
	    public double getMasse() {
	    	return masse;
	    	
	    }
	    
	    
	    // Setter, Getter de l'age de l'animal
	    
	    @Override
	    public void setAge( int age ) {
	    	this.age = age;
	    	
	    }
	    
	    @Override
	    public int getAge() {
	    	return age;
	    	
	    }
	    
	    
	    // Getters de l'age mature et de l'age maximum de l'animal
	    
	    @Override
	    public int getAgeMature() {
	    	return ageMature;
	    	
	    }
	    
	    @Override
	    public int getAgeMax() {
	    	return ageMax;
	    	
	    }
	    
	    
	    // Retourne le facteur de croissance de l'animal
	    public double getFacteurCroissance() {
	    	return facteurCroissance;
	    	
	    }
	    
	    // Ce n'est pas pertinent qu'un animal accouche, car il
	    // faut creer des objets qui sont soient des antilopes, soient des lions
	    @Override
	    public abstract Animal accoucher();
	    
	    
	    // L'animal mange
	 	@Override
	 	public void manger() {
	 	    // ...
	 		
	 	}
	    
}