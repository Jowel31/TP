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

// Abstraite, car l'instanciation d'un animal n'aurait pas de sens.
// (Un lion et une antilope peuvent etre instancies,
// mais un animal n'est pas un objet concret)
public abstract class Animal implements ProiePredateur {

	// Variables
	private int age;	   			  // Age courant
	private int ageMature; 			  // Age minimum pour s'accoupler
	private int ageMax;    			  // Age maximum avant la mort

	private double masse;  			  // Masse courante
	private double facteurCroissance; // Facteur de prise de masse par annee

	private boolean estVivant;    	  // L'animal est en vie
	private boolean estProie;     	  // L'animal est une proie
	private boolean estPredateur; 	  // L'animal est un predateur


	// Constructeur
	public Animal(double facteurCroissance, int ageMature, int ageMax) {

		// Association des attributs
		this.facteurCroissance = facteurCroissance;
		this.ageMature 		   = ageMature;
		this.ageMax 		   = ageMax;

		naitre();

	}


	/////////////////////
	// Getters/Setters //
	/////////////////////

	// Retourne si l'animal est mature ou non
	@Override
	public boolean estMature() { return age >= ageMature; }

	// Retourne si l'animal est vivant ou non
	@Override
	public boolean estVivant() { return estVivant; }

	
	// Fixe si l'animal est une proie ou non
	@Override
	public void setProie( boolean proie ) { estProie = proie; }

	// Retourne si l'animal est une proie ou non
	@Override
	public boolean estProie() { return estProie; }

	
	// Fixe si l'animal est un predateur ou non
	@Override
	public void setPredateur( boolean predateur ) { estPredateur = predateur; }

	// Retourne si l'animal est un predateur ou non
	@Override
	public boolean estPredateur() { return estPredateur; }

	
	// Fixe la masse
	@Override
	public void setMasse( double masse ) { this.masse = masse; }

	// Retourne la masse
	@Override
	public double getMasse() { return masse; }

	
	// Fixe l'age
	@Override
	public void setAge( int age ) { this.age = age; }

	
	// Retourne l'age
	@Override
	public int getAge() { return age; }

	
	
	// Retourne l'age mature
	@Override
	public int getAgeMature() {	return ageMature; }

	
	// Retourne l'age maximum
	@Override
	public int getAgeMax() { return ageMax; }

	
	
	// Retourne le facteur de croissance
	public double getFacteurCroissance() { return facteurCroissance; }


	
	///////////////
	//  Actions  //
	///////////////

	// L'animal prend vie et recoit un age initial et une masse initiale
	@Override
	public void naitre() {
		setAge(0);
		setMasse(10);
		estVivant = true;
	}

	
	// L'animal viellit d'un an. Il meurt s'il depasse son age maximum
	// et il devient mature s'il atteint l'ageMature.
	// Sa masse augmente selon son facteur de croissance.
	@Override
	public void vieillir() {

		age ++;

		if (age > ageMax) { mourir(); } else
		masse *= facteurCroissance;

	}

	
	// L'animal meurt
	@Override
	public void mourir() { estVivant = false; }

	
	// L'animal a reussi a manger
	@Override
	public void manger() { 
		// Aucune specification 
	}

	
	// l'animal accouche d'un enfant de son type.
	@Override
	public abstract Animal accoucher();


}