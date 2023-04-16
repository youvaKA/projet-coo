package competitions.matches;

import java.util.ArrayList;
import java.util.List;

import competitions.Competition;
import competitions.competitors.*;
import competitions.observers.Observers;

/**
 * this class is the base class for all matches type that could be created, used in a competition.
 * @author  (Youva KAOUI)
 * @version (livrable 1)
 */
public abstract class AbstractMatch implements Match, MatchObservables {

	public Competition comp;
	public List<Observers> lstObservers;
	
	public AbstractMatch(Competition comp) {
		this.comp = comp;
		this.lstObservers = new ArrayList<>();
	}
	/**
	 * this method use another one, pickWinner from the same class and add a point to the winner.
	 * @param player1 The first competitor.
	 * @param player2 The second competitor. 
	 */
	public void play(Competitor player1, Competitor player2){

		Competitor winner = this.pickWinner(player1, player2);
		Competitor looser ;
		if (winner.equals(player1)) looser = player2 ; 
		else looser = player1 ;
		this.comp.addPoint(winner);
		
		this.notifyObservers(winner, looser);

	}

	public void setCompetition (Competition c){
		this.comp = c ;
	}

	public void notifyObservers(Competitor win, Competitor loos){
		
		for(Observers obs : this.lstObservers){
			obs.display(win, loos);
		}
	}

	public abstract Competitor pickWinner(Competitor player1, Competitor player2);

	public void addObserver(Observers obs){
		this.lstObservers.add(obs);
	}
	
	public void removeObserver(Observers obs){
		this.lstObservers.remove(obs);
	}
}
