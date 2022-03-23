// Fichier :     Population.java
// Création:     22 mars 2022
// Auteurs :     Joel Villeneuve
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Population
    implements EcoSysteme, Iterable<Animal>

 **/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;


// Definis une population d'herbe et d'animaux (proies et predateurs), iterable.

public class Population implements EcoSysteme, Iterable<Animal> {

	private Herbe herbe;
	private ArrayList<Animal> individus = new ArrayList<>();
	
	
	// Constructeur
	public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {

		this.herbe = herbe;

		this.individus.addAll(proies);
		this.individus.addAll(predateurs);

	}

	// Retourne un iterator de la liste individus.
	@Override
	public Iterator<Animal> iterator() {	
		return this.individus.iterator();
	}

	///////////////
	//  Getters  //
	///////////////
	
	public ArrayList<Animal> getIndividus(){
		return this.individus;
	}

	@Override
	public int getNombreProies() {

		int count = 0;

		for (Animal animal : individus) {

			if (animal.estProie()) { count ++; }
		}

		return count;
	}

	@Override
	public int getNombrePredateurs() {

		int count = 0;

		for (Animal animal : individus) {

			if (animal.estProie()) { 
				count ++;
			}
		}

		return count;
	}

	@Override
	public int getNombreProiesMatures() {

		int count = 0;

		for( Animal animal : individus ) {

			if (animal.estProie() && animal.estMature()) { 
				count ++;
			}
		}

		return count;
	}

	@Override
	public int getNombrePredateursMatures() {

		int count = 0;

		for( Animal animal : individus ) {

			if (animal.estPredateur() && animal.estMature()) { 
				count ++;
			}
		}

		return count;
	}

	@Override
	public int getNombreProiesChassables() {
		return (int) (getNombreProies() * 0.2);
	}

	@Override
	public double masseProies() {
		
		
		double masse = 0;

		for (Animal animal : individus) {

			if (animal.estProie()) { masse += animal.getMasse(); }
		}
		
		return masse;
	}

	@Override
	public double massePredateurs() {
		
		double masse = 0;

		for (Animal animal : individus) {

			if (animal.estPredateur()) { masse += animal.getMasse(); }
		}
		
		return masse;
	}

	///////////////
	//  Actions  //
	///////////////
	
	// Fait vieillir d'une annee tous les animaux.
	@Override
	public void vieillir() {

		herbe.vieillir(); 
		individus.forEach( animal -> { animal.vieillir(); } );
	}

	// Nourris les proies d'herbe et nourris les predateurs de proies.
	@Override
	public void chasser() {

		melanger(); // melanger la liste individus

		int nProiesChassables = getNombreProiesChassables(); // nombre de proies restantes
		double masseHerbe     = herbe.getMasseAnnuelle();    // masse d'herbe restante

		Iterator<Animal> it = iterator();

		// On fait manger chaque animal.
		while (it.hasNext()) {

			Animal animal = it.next();

			if (animal.estVivant()) {

				// Les proies mangent de l'herbe et les predateurs mangent leurs proies
				if (animal.estProie()) { masseHerbe        = mangeHerbe(animal, masseHerbe); } 
				else                   { nProiesChassables = mangeProie(animal, nProiesChassables); }
				
			}
		}
		
	}

	// Prend en parametre un animal. et lui fait manger de l'herbe pour 2 fois sa masse.
	// Retourne la masse d'herbe restante
	private double mangeHerbe(Animal animal, double masseHerbe) {

		double masseAnimal = animal.getMasse();
		
		if (masseHerbe >= masseAnimal * 2) { // Assez d'herbe pour nourrir l'antilope

			masseHerbe -= masseAnimal * 2;
			animal.manger();

		} else { animal.mourir(); }

		return masseHerbe;
	}

	// Prend en parametre un predateur. Lui fait manger des proies pour 2 fois sa masse.
	// Retourne le nombre de proies restante.
	private int mangeProie(Animal predateur, int nProiesChassables) {


		Iterator<Animal> itProies = iterator(); // itere aux travers des animaux a manger

		double masseAnimal = predateur.getMasse();
		double masseMangee = 0;

		while (nProiesChassables > 0) {

			Animal proie = itProies.next();

			if (proie.estProie() && proie.estVivant()) { // l'animal est mangeable
				
				masseMangee += proie.getMasse();
				proie.mourir();
				
				nProiesChassables --;

				if(masseMangee >= masseAnimal * 2) { // Le predateur est nourrit
					predateur.manger();
					break;
				}
			}

		}
		
		return nProiesChassables;
	}

	// Fait accoucher les femelles des proies et des predateurs
	@Override
	public void reproduire() {
		
		int couplesProiesMatures     = getNombreProiesMatures() / 2;
		int couplesPredateursMatures = getNombrePredateursMatures() / 2;
		
		for(Animal animal : individus) {
			
		}
	}

	// Melange la liste d'animaux.
	@Override
	public void melanger() { 
		Collections.shuffle(this.individus, new Random(4));
	}


}
