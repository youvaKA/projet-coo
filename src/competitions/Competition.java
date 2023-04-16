package competitions;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitions.competitors.*;
import competitions.matches.AbstractMatch;

import competitions.observers.Observers;
import competitions.utiles.MapUtil;

/**
 * Competition is the abstract class that represents a competition. It is
 * composed of a list of competitors, a scoreboard,
 * a match, and a list of observers.
 * 
 * @author  (Youva KAOUI)
 * @version (livrable 1)
 */

public abstract class Competition {

	private final List<Competitor> competitors;
	protected Map<Competitor, Integer> scoreboard;
	private AbstractMatch match;
	public List<Observers> obs;

	/**
	 * The Competition constructor
	 * 
	 * @param Competitors The list of competitors in the competition
	 */
	
	public Competition(List<Competitor> Competitors) {
		this.competitors = Competitors;
		this.scoreboard = new HashMap<>();
		this.obs = new ArrayList<>();

		for (Competitor competitor : Competitors) {
			scoreboard.put(competitor, 0);
		}
	}

	/**
	 * plays the match between two competitors
	 * 
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	protected void playMatch(Competitor c1, Competitor c2) {

		System.out.println(c1 + " vs " + c2);
		this.getMatch().play(c1, c2);

	}

	/**
	 * Plays the competition between all the competitors
	 * 
	 * @param players The list of competitors
	 */
	protected abstract void play(List<Competitor> players);


		/**
	 * Gets the match object
	 * @return the match object
	 */
	public AbstractMatch getMatch() {
		return this.match;
	}

	/**
	 * Sets the match object
	 * @param match the match object
	 */
	public void setMatch(AbstractMatch match) {

		this.match = match;

		match.setCompetition(this);

	}

	/**
	 * Plays the competition
	 */
	public void play() {
		this.play(this.competitors);
	}

		/**
	 * Gets the ranking of the competitors
	 * @return the scoreboard
	 */

	public Map<Competitor, Integer> ranking() {
		return this.scoreboard;
	}

		/**
	 * Gets the list of competitors
	 * @return the list of competitors
	 */
	public List<Competitor> getCompetitors() {
		return competitors;
	}

		/**
	 * Sets the scoreboard
	 * @param scoreboard the scoreboard of the competition
	 */
	public void setScoreboard(Map<Competitor, Integer> scoreboard) {
		this.scoreboard = scoreboard;
	}

		/**
	 * Adds a point to a competitor
	 * @param player1 the competitor to add a point to
	 */
	public void addPoint(Competitor player1) {
		int oldValue = this.scoreboard.get(player1);
		this.scoreboard.put(player1, oldValue + 1);

	}

		/**
	 * Adds an observer to the match
	 * @param observ the observer to add
	 */
	public void iWantToObserve(Observers observ) {

		this.match.addObserver(observ);
	}

		/**
	 * Returns a string representation of the competition and rankings
	 * @return the string representation
	 */

	public String toString() {
		this.scoreboard = MapUtil.sortByDescendingValue(this.ranking());
		String output = "*** " + this.getClass().getSimpleName() + " Ranking ***\n";
		for (Entry<Competitor, Integer> myEntry : this.scoreboard.entrySet()) {
			output += myEntry.getKey() + " - " + myEntry.getValue() + "\n";
		}
		return output;
	}

}
