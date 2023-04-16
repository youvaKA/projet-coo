package competitions.matches;
import java.util.Random;
import competitions.Competition;
import competitions.competitors.*;

/**
 * this class creates a randomMatch that will pick a winner randomly.
 */
public class RandomMatch extends AbstractMatch { 	
	private static Random myRandomMaker = new Random();
/**
 * the contructor of the randomMatch class.
 * @param comp the competition in which the randomMatch will be played.
 */
	public RandomMatch(Competition comp) {
		super(comp);
	}
/**
 * the pickWinner method will randomly choose a player from the two given in parameter.
 * @param player1 the first competitor from the two to choose from.
 * @param player2 the second competitor from the tow to choose from.
 */
	@Override
	
	public Competitor pickWinner(Competitor player1, Competitor player2) {

			if (myRandomMaker.nextBoolean()) {
				return player1;
			}
			return player2;
	}

	
}
