// Fichier :     Herbe.java
// Creation:     2022.03.03
// Auteur :      francois.major@umontreal.ca
//
// Ce code n'est pas protege par un copyright.
// 
// Historique :
//  Creee pour le cours IFT1025 H22
//

/**
   class Herbe

   @author <A HREF="mailto:francois.major@umontreal.ca">Francois Major</A>
   @version $Revision: 1.0 $ $Date: 2022/03/03 $
   @see 
**/

public class Herbe {
    
    // the maximum possible herb mass (upper limit)
    private double masseCritique;
    // current herb mass
    private double masse;
    // herb mass consumable in one year
    private double masseAnnuelle;
    // herb growth rate
    private double tauxCroissance;
    
    public Herbe( double masse, double masseCritique, double tauxCroissance ) {
        this.masse = masse;
        this.masseAnnuelle = 0.6 * this.masse; // backup herb of 60% of the current mass
        this.masseCritique = masseCritique;
        this.tauxCroissance = tauxCroissance;
    }
    // getters
    public double getMasse() { return masse; }
    // setters
    public void setMasse( double masse ){ this.masse = masse; }
    // behavior
    public void vieillir(){
        //this.masseAnnuelle = Math.max( 0, this.masseAnnuelle );
        this.masse = this.masse * 0.4 + this.masseAnnuelle;
        this.masse = Math.min( this.masse * this.tauxCroissance, this.masseCritique );
        this.masseAnnuelle = this.masse * 0.6; // backup herb of 60% of the current mass
    }
    public String toString() { return "[" + this.getMasse() + " d'herbe]"; }
    
	public double getMasseAnnuelle() {
		return this.masseAnnuelle;
	}
}
