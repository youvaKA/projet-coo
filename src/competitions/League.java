package competitions;

import java.util.List;
import java.util.ListIterator;

import competitions.competitors.Competitor;

/**
*This class is a competition mode, and so is a child-class from Competition.
 * 
 * @author  (Youva KAOUI)
 * @version (livrable 1)
 */

public class League extends Competition {

	public League(List<Competitor> Competitors) {
		super(Competitors);
	}

	/**
	 * the method will call the winner selecting method from the match type wanted,
	 * then print the results.
	 * 
	 * @param c1 the first competitor that will play the following match
	 * @param c2 the second competitor that will play the following match
	 * 
	 */

	/**
	 * protected void playMatch(Competitor c1, Competitor c2) {
	 * Competitor winner = this.match.pickWinner(c1, c2);
	 * System.out.println(c1 + " vs " + c2 + " --> " + winner + " wins !");
	 * this.scoreboard.put(winner, this.scoreboard.get(winner) + 1);
	 * }
	 */

	/**
	 * the play method will make all the competitors play in pairs, at the end there
	 * is only one winner.
	 * 
	 * @param competitors the list of competitors that will be given to the
	 *                    playMatch method.
	 * 
	 */

	public void play(List<Competitor> competitors) {
		ListIterator<Competitor> iterator = competitors.listIterator();
		while (iterator.hasNext()) {
			Competitor c = iterator.next();
			ListIterator<Competitor> iteratorbis = competitors.listIterator();
			while (iteratorbis.hasNext()) {
				Competitor c2 = iteratorbis.next();
				if (c != c2)
					this.playMatch(c, c2);

			}
		}
	}

	/**
	 * 
	 * autre Algo
	 * 
	 * protected void play(List<Competitor> Competitors) {
	 * 
	 * for (int i = 0; i < 2; i++) {
	 * for (Competitor player1 : Competitors) {
	 * for (Competitor player2 : Competitors) {
	 * if (player1 != player2) {
	 * playMatch(player1, player2);
	 * }
	 * }
	 * }
	 * }
	 * }
	 */

}