package competitions.strategies;

import java.util.ArrayList;
import java.util.List;

import competitions.League;
import competitions.Master;
import competitions.competitors.Competitor;
import competitions.utiles.MapUtil;

/**
 * PickFirst est une classe qui implémente l'interface Strategies.
 * Elle est utilisée pour déterminer le candidat final à partir d'un ensemble de ligues.
 * 
 * @author Competitions
 *
 */
public class PickFirst implements Strategies {

	private Master master;

	/**
	 * Cette méthode retourne une liste des compétiteurs finaux à partir des ligues.
	 * 
	 * @return Liste de compétiteurs
	 */
	@Override
	public List<Competitor> getFinalCompetitors() {
		List<Competitor> otp = new ArrayList<>();
		for (League league : this.getMaster().getPoolPhase().getLeagueList()) {
			otp.add(MapUtil.getTheBest(league.ranking()));
		}
		return otp;
	}

		/**
	 * Cette méthode définit le Maître à partir d'une instance de Maître.
	 * 
	 * @param master Instance de Maître
	 */

	@Override
	public void setMaster(Master master) {
		this.master = master;
		
	}

		/**
	 * Cette méthode retourne une instance de Maître.
	 * 
	 * @return Instance de Maître
	 */

	@Override
	public Master getMaster() {
		return this.master;
	}
	
}