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
	private ArrayList<Animal> individus = new ArrayList<Animal>();


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

		retirerMorts();
	}

	// Fait chasser les animaux.
	@Override
	public void chasser() {

		melanger();

		double masseHerbe          = herbe.getMasseAnnuelle();
		int nombreProiesChassables = getNombreProiesChassables();

		// Faire manger chaque animal
		for (int i = 0; i < individus.size(); i++) {

			Animal animal = individus.get(i);

			if (!animal.estVivant()) continue; // Les animaux morts ne chassent pas.

			double masseAnimal = animal.getMasse();

			if (animal.estProie()) { // Manger de l'herbe

				if (masseHerbe >= masseAnimal * 2) {
					masseHerbe -= masseAnimal * 2;
					animal.manger();

				} else animal.mourir();


			} else { // Manger des proies

				Animal proie;
				double masseMangee = 0;

				for (int j = 0; j < individus.size(); j++) { // Parcourir les animaux a manger

					if (nombreProiesChassables == 0) { animal.mourir(); break; } // toutes les proies ont ete mangees

					proie = individus.get(j);

					if (proie.estProie() && proie.estVivant()) { // proie mangeable
						masseMangee += proie.getMasse();
						proie.mourir();
						nombreProiesChassables --;

						individus.set(j, proie);
					}

					if (masseMangee >= masseAnimal * 2) { animal.manger(); break; } // animal nourrit
				}
			}

			individus.set(i, animal); // Mettre a jour l'animal.

		}

		retirerMorts();
	}

	// Fait accoucher un bebe par couple d'animaux.
	// Fait accoucher les femelles des proies et des predateurs
	@Override
	public void reproduire() {

		int couplesProies     = getNombreProiesMatures() / 2;
		int couplesPredateurs = getNombrePredateursMatures() / 2;

		Animal bebe;

		for (Animal animal : individus) {

			if (animal.estPredateur() && animal.estMature()) {
				bebe = animal.accoucher();
				individus.add(bebe);
				couplesPredateurs --;

				if (couplesPredateurs == 0) break;
			}
		}
		for (Animal animal : individus) {

			if (animal.estProie() && animal.estMature()) {
				bebe = animal.accoucher();
				individus.add(bebe);
				couplesProies --;

				if (couplesProies == 0) break;
			}
		}
	}
	
	// Melange la liste d'individus.

	// Melange la liste d'animaux.
	@Override
	public void melanger() { 
		Collections.shuffle(this.individus, new Random(4));
	}


	// Retire les animaux morts de la liste d'individus.
	private void retirerMorts() {

		individus.forEach( animal -> { 
			if (!animal.estVivant()) individus.remove(animal); 
		});
	}

}
