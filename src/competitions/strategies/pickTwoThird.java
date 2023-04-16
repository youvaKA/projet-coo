package competitions.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitions.League;
import competitions.Master;
import competitions.competitors.Competitor;
import competitions.utiles.MapUtil;

/**
 * La classe pickTwoThird implémente l'interface Strategies. Elle permet de choisir les 2 premiers
 * concurrents de chaque ligue et le suivant qui a le plus de points.
 * 
 * @author  (Youva KAOUI)
 * @version (livrable 2)
 */

public class pickTwoThird implements Strategies {

	private Master master;
	
		/**
     * Cette méthode permet de retourner les concurrents finaux
     * 
     * @return Liste des concurrents finaux
     */
	@Override
	public List<Competitor> getFinalCompetitors() {
		List<Competitor> otp = new ArrayList<>();
		Map<Competitor, Integer> otp2 = new HashMap<>();

		for (League league : this.getMaster().getPoolPhase().getLeagueList()) {
			int cpt = 0;

			for (Map.Entry<Competitor, Integer> entry : league.ranking().entrySet()) {
				cpt++;
				if (cpt <= 2) {
					otp.add(entry.getKey());
				} else if (cpt == 3) {
					otp2.put(entry.getKey(), entry.getValue());
					
				}
			}
		}
		otp2 = MapUtil.sortByDescendingValue(otp2);
		int cpt2 = 0;
		for (Map.Entry<Competitor, Integer> entry : otp2.entrySet()) {
			cpt2++;

			if (cpt2 <= 2) {
				otp.add(entry.getKey());
			} 
		}

		return otp;
	}

		/**
     * Cette méthode permet d'assigner le Master à la classe
     * 
     * @param master Master à assigner
     */
	@Override
	public void setMaster(Master master) {
		this.master = master;

	}
		/**
     * Cette méthode permet de retourner le Master
     * 
     * @return Master assigné à la classe
     */
	@Override
	public Master getMaster() {
		return this.master;
	}

}
