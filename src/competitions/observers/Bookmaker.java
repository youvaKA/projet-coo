package competitions.observers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitions.competitors.Competitor;


public class Bookmaker implements Observers {

    /**
 * Bookmaker est une classe qui implémente l'interface Observers. 
 * Cette classe définit un bookmaker qui observe les compétiteurs et détermine ses côtes pour chaque compétiteur.
 *
 * @author  (Youva KAOUI)
 * @version (livrable 3)
 */

    public List<Competitor> competitors ;
    Map<Competitor,Integer> competitorsCotes ;
    public String name ;

    /** 
     * Constructeur de la classe Bookmaker
     *
     * @param  name  le nom du bookmaker
     * @param  competitors la liste des compétiteurs
     */
    public Bookmaker(String name ,List<Competitor> competitors) {
        this.name = name;
        this.competitors = competitors ;
        this.competitorsCotes = new HashMap<>();
        for (Competitor comp : this.competitors)
            this.competitorsCotes.put(comp, 3);
    }
    /** 
     * getCotes est une methode qui permet de récupérer la cote d'un compétiteur
     *
     * @param  competitor le compétiteur dont on veut récupérer la cote
     * @return la cote du compétiteur 
     */

    public int getCotes(Competitor competitor){
        return this.competitorsCotes.get(competitor);
    }
        /** 
     * incrementOdd est une methode qui permet d'incrémenter la cote d'un compétiteur
     *
     * @param  comp le compétiteur dont on veut incrémenter la cote
     */

    public void incrementOdd(Competitor comp){
        this.competitorsCotes.put(comp, getCotes(comp) + 1);
    }

    /** 
     * decrementOdd est une methode qui permet de décrémenter la cote d'un compétiteur
     *
     * @param  comp le compétiteur dont on veut décrémenter la cote
     */

     public void decrementOdd(Competitor comp){
        if (this.competitorsCotes.get(comp) > 1){
                this.competitorsCotes.put(comp, getCotes(comp) - 1);
        }
    }  

    /** 
     * getOdd est une methode qui permet de récupérer la cote d'un compétiteur
     *
     * @param  competitor le compétiteur dont on veut récupérer la cote
     * @return la cote du compétiteur 
     */

    public int getOdd(Competitor competitor) {
        return this.competitorsCotes.get(competitor);
    }

    /** 
     * display est une methode qui permet d'afficher le résultat des paris sportifs
     *
     * @param  win le compétiteur gagnant
     * @param  loose le compétiteur perdant
     */

    @Override
    public void display(Competitor win, Competitor loose) {
        System.out.println("\n -------PARIS SPORTIFS-------");
        System.out.println("Suite à la victoire de "+win+" votre Bookmaker préféré " + name + ", \nvous annonce les nouvelles côtes : \n");

        System.out.println("Les côtes actuelles sont pour : ");
        for (Competitor competitor : this.competitors)
            System.out.println("côte de : "+competitor.getName() + " => " + this.competitorsCotes.get(competitor));
    
        this.incrementOdd(loose);
        this.decrementOdd(win);
        //System.out.println("Victoire de : " + win.getName() + " : " + this.competitorsCotes.get(win));
    
        System.out.println( "---\n"+"Les nouvelles côtes sont pour :");
        for (Competitor competitor : this.competitors)
        System.out.println("côte de : "+competitor.getName() + " => " + this.competitorsCotes.get(competitor));
        
        System.out.println("------------------------------------------------------" + "\n");
    
    }

}
