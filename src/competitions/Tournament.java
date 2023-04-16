package competitions;

import java.util.Set;

import competitions.competitors.*;

import java.util.HashSet;
import java.util.List;

/** 
 * La classe Tournament est une sous-classe de la classe Competition qui permet de définir un tournoi.
 * Les attributs de cette classe sont hérités de la classe Competition.
 * La méthode play() permet de jouer le tournoi en prenant une liste de participants en paramètre.
 * La méthode playMatch() permet de jouer une partie en prenant les deux participants en paramètre.
 * @author  (Youva KAOUI)
 * @version (livrable 2)
 */

public class Tournament extends Competition {

	public Tournament(List<Competitor> Competitors) {
		super(Competitors);
	}

	/**

	 *           the method will call the winner selecting method from the match
	 *           type wanted.
	 *           then print the results.
	 * @param c1 the first competitor that will play the following match
	 * @param c2 the second competitor that will play the following match
	 */

	protected void playMatch(Competitor c1, Competitor c2) {
		this.getMatch().play(c1, c2);
	}

	/**

	 *                    The play method will run the tournament, given the number
	 *                    of competitors is a even number.
	 *                    the tournament will be played in list order two by two.
	 *                    When a competitor loose, he gets removed from the
	 *                    tournament.
	 *                    as long as there is more than 1 player remaining in the
	 *                    competitors list, the tournament will play again.
	 * @param Competitors the list of competitors participating the tournament.
	 */

	protected void play(List<Competitor> Competitors) {
		double var = Math.log(Competitors.size()) / Math.log(2);

		if (var % 1 != 0) {
			throw new RuntimeException("player size must be a power of two");
		}

		Set<Competitor> toRemove;
		while (Competitors.size() > 1) {
			toRemove = new HashSet<Competitor>();

			for (int i = 1; i < Competitors.size(); i += 2) {
				Competitor winner = this.getMatch().pickWinner(Competitors.get(i - 1), Competitors.get(i));
				System.out.println(Competitors.get(i) + " vs " + Competitors.get(i - 1) + " --> " + winner + " wins !");
				scoreboard.put(winner, scoreboard.get(winner) + 1);
				if (winner == Competitors.get(i - 1)) {
					toRemove.add(Competitors.get(i));
				} else {
					toRemove.add(Competitors.get(i - 1));
				}
			}
			Competitors.removeAll(toRemove);
		}

	}

	// AUTRE ALGORITHM

	// public void play1(List<Competitor> competitors) {
	// ListIterator<Competitor> iterator = competitors.listIterator();
	// while (iterator.hasNext()) {
	// Competitor c = iterator.next();
	// ListIterator<Competitor> iteratorbis = competitors.listIterator();
	// while (iteratorbis.hasNext()) {
	// Competitor c2 = iteratorbis.next();
	// if (c != c2)
	// playMatch(c, c2);

	// }
	// }
	// }

}