package competitions;

import java.util.ArrayList;
import java.util.List;

import competitions.competitors.Competitor;

import competitions.strategies.Strategies;
import competitions.utiles.MapUtil;

/**
 * This class is a competition mode, and a child-class from competition.
 * Originally meant to be used with the PoolPhase class.
 * @author  (Youva KAOUI)
 * @version (livrable 2)
 */

public class Master extends Competition {

    protected int nbGroup;
    protected PoolPhase poolPhase;
    public Strategies strategie;

    
    /**
     * Constructor for Master competition
     * @param Competitors List of competitors
     * @param nbGroup The number of groups
     * @param strategie The strategy used to determine which competitors will participate in the final tournament
     */

    public Master(List<Competitor> Competitors, int nbGroup, Strategies strategie) {
		super(Competitors);
		this.nbGroup = nbGroup;
		this.poolPhase = new PoolPhase(Competitors, nbGroup);
		this.strategie = strategie;
        this.strategie.setMaster(this);
	}

    /**
     * Gets the PoolPhase object
     * @return The poolPhase object
     */

    public PoolPhase getPoolPhase() {
        return poolPhase;
    }

    	/**
	 * Gets the number of groups
	 * @return The number of groups
	 */
	public int getNbGroup() {
        return nbGroup;
    }
	
    

	@Override
    protected void playMatch(Competitor c1, Competitor c2) {
    }

    /**
 * The following method will use poolphase to sort competitors then use
 * the strategies interface to select the competitors that will play
 * the masters.
 * @param players the list of competitors that could be selected to play the masters
 */

    @Override
    protected void play(List<Competitor> players) {
        this.poolPhase.setMatch(this.getMatch());
    	this.poolPhase.play(players);
        List<Competitor> l2 = new ArrayList<Competitor>();
        l2 = this.strategie.getFinalCompetitors();
        Tournament tmp = new Tournament(l2);
        tmp.setMatch(this.getMatch());
        tmp.play(l2);
        scoreboard = tmp.ranking();
    }

    @Override
    public String toString() {
    	return "\n***Master Winner***\n" + MapUtil.getTheBest(scoreboard);
    }
}
