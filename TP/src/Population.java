// Fichier :     Population.java
// Création:     22 mars 2022
// Auteur  :     Joel Villeneuve
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
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;


// Definis une population d'herbe et d'animaux (proies et predateurs), iterable.
public class Population implements EcoSysteme, Iterable<Animal> {

	private Herbe herbe;
	private ArrayList<Animal> individus = new ArrayList<Animal>(); // contient tous les animaux


	// Constructeur
	public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {

		this.herbe = herbe;

		this.individus.addAll(proies);
		this.individus.addAll(predateurs);

	}
	
	///////////////
	//  Getters  //
	///////////////

	// Retourne la liste d'individus
	public ArrayList<Animal> getIndividus() { return this.individus; }
	
	// Retourne un iterator de la liste individus.
	@Override
	public Iterator<Animal> iterator() { return individus.iterator(); }


	// Compte et retourne le nombre de proies
	@Override
	public int getNombreProies() {

		int count = 0;

		for (Animal animal : individus) 
			if (animal.estProie()) count ++;

		return count;
	}

	// Compte et retourne le nombre de predateurs
	@Override
	public int getNombrePredateurs() {

		int count = 0;

		for (Animal animal : individus)
			if (animal.estPredateur()) count ++;

		return count;
	}

	// Compte et retourne le nombre de proies matures
	@Override
	public int getNombreProiesMatures() {

		int count = 0;

		for( Animal animal : individus ) 
			if (animal.estProie() && animal.estMature()) count ++;
		

		return count;
	}

	// Compte et retourne le nombre de predateurs
	@Override
	public int getNombrePredateursMatures() {

		int count = 0;

		for( Animal animal : individus )
			if (animal.estPredateur() && animal.estMature()) count ++;

		return count;
	}

	// Calcule et retourne le nombre de proies chassables.
	// 20% du nombre total de proies. (Arroundi vers le bas)
	@Override
	public int getNombreProiesChassables() {
		return getNombreProies() / 5;
	}

	// Calcule et retourne la masse combinee des proies
	@Override
	public double masseProies() {

		double masse = 0;

		for (Animal animal : individus)
			if (animal.estProie()) masse += animal.getMasse();

		return masse;
	}

	// Calcule et retourne la masse combinee des predateurs
	@Override
	public double massePredateurs() {

		double masse = 0;

		for (Animal animal : individus)
			if (animal.estPredateur()) masse += animal.getMasse();

		return masse;
	}

	///////////////
	//  Actions  //
	///////////////

	// Fait vieillir la population d'une annee.
	@Override
	public void vieillir() {

		herbe.vieillir();
		individus.forEach( animal -> animal.vieillir() );
		
		retirerMorts();
	}

	/* Simule une saison de chasse pour la population. Dans l'ordre de la liste individus
	   melangee, les animaux mangent leur nourriture pour 2 fois leur masse. Les proies 
	   mangent de l'herbe. Les predateurs mangent des proies dans l'ordre de la liste.
	   Les animaux qui ne peuvent se nourrir ou qui sont manges par d'autres meurent. */
	@Override
	public void chasser() {

		melanger();
		
		//double masseHerbe          = herbe.getMasseAnnuelle();    // masse d'herbe restante
		int nombreProiesChassables = getNombreProiesChassables(); // nombre de proies restantes

		// Faire chasser chaque animal
		for (Animal animal : individus) { 
			
			if (!animal.estVivant()) continue; // Les animaux morts ne chassent pas.
			
			double masseRequise = animal.getMasse() * 2; // masse requise pour nourrir l'animal
			
			if (animal.estProie()) { // Manger de l'herbe

				double masseHerbeRestante = herbe.getMasseAnnuelle(); // masse d'herbe restante pour l'annee
				
				if (masseHerbeRestante >= masseRequise) { // Assez d'herbe restante
					herbe.setMasseAnnuelle(masseHerbeRestante - masseRequise); // retirer la masse d'herbe mangee
					animal.manger();
					
				} else animal.mourir();

				
			} else { // Manger des proies

				double masseMangee = 0;
				
				for (Animal proie : individus) { // Parcourir les animaux a manger

					if (nombreProiesChassables == 0) { animal.mourir(); break; } // Toutes les proies ont ete mangees

					if (proie.estProie() && proie.estVivant()) { // proie mangeable
						
						masseMangee += proie.getMasse();
						proie.mourir();

						nombreProiesChassables --;
					}
					
					if (masseMangee >= masseRequise) { animal.manger(); break; } // l'animal a fini de manger
				}
			}
		}
		
		retirerMorts();
	}

	// Fait accoucher un bebe par couple d'animaux matures.
	@Override
	public void reproduire() {

		int couplesProies     = getNombreProiesMatures() / 2; 	  //nombre d'accouplements de proies restants
		int couplesPredateurs = getNombrePredateursMatures() / 2; //nombre d'accouplements de predateurs restants

		ArrayList<Animal> nouveauxNes = new ArrayList<Animal>(); // stocke les animaux qui naissent
		Animal bebe;
		
		
		for (Animal animal : individus) 
			if (animal.estMature())

				if (animal.estPredateur() && couplesPredateurs > 0 ) { // le predateur peut s'accoupler
					
					bebe = animal.accoucher();
					nouveauxNes.add(bebe);
					
					couplesPredateurs --;

				} else if (animal.estProie() && couplesProies > 0) {   // la proie peut s'accoupler

					bebe = animal.accoucher(); 
					nouveauxNes.add(bebe);
					
					couplesProies --; 
					
			}

		individus.addAll(nouveauxNes); // Ajouter a la liste d'individus les animaux qui sont nes
	}

	// Melange la liste d'individus.
	@Override
	public void melanger() { Collections.shuffle(individus, new Random(4)); }

	// Retire les animaux morts de la liste d'individus.
	private void retirerMorts() { individus.removeIf(animal -> !animal.estVivant()); }

}
