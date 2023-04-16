

import competitions.Competition;
import competitions.competitors.Competitor;
import competitions.matches.AbstractMatch;


public class MockMatch extends AbstractMatch {

    public MockMatch(Competition comp) {
        super(comp);
    }

    @Override
    public Competitor pickWinner(Competitor player1, Competitor player2) {

        return player1;

    }
}
