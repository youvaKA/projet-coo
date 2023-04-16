package competitions.strategies;

import java.util.ArrayList;
import java.util.List;

import competitions.League;
import competitions.Master;
import competitions.competitors.Competitor;
import competitions.utiles.MapUtil;

/**
 * La classe PickSecond définit une stratégie pour le choix de compétiteurs pour le master.
 * Elle implémente l'interface Strategies et définit la méthode getFinalCompetitors() qui permet
 * de sélectionner les deux meilleurs compétiteurs de chaque ligue dans le master.
 * 
 * @author  (Youva KAOUI)
 * @version (livrable 2)
 */

public class PickSecond implements Strategies {

    private Master master;

	/**
    * Cette méthode permet de récupérer les deux meilleurs compétiteurs de chaque ligue dans le master.
    *
    * @return List<Competitor> une liste contenant les deux meilleurs compétiteurs de chaque ligue dans le master
    */
	@Override
	public List<Competitor> getFinalCompetitors() {
		List<Competitor> otp = new ArrayList<>();
        int cpt =0;
		for (League league : this.getMaster().getPoolPhase().getLeagueList()) {
			cpt ++;
            if (cpt <= 2){
                otp.add(MapUtil.getTheBest(league.ranking()));
            }else break;
		}
		return otp;
	}

	 /**
    * Cette méthode permet de définir le master.
    *
    * @param master le master à définir
    */

	@Override
	public void setMaster(Master master) {
		this.master = master;
		
	}

	    /**
    * Cette méthode permet de récupérer le master.
    *
    * @return Master le master
    */

	@Override
	public Master getMaster() {
		return this.master;
	}
    
}
 