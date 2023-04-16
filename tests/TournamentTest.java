

import competitions.Tournament;
import competitions.competitors.*;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import competitions.*;


//import org.junit.jupiter.api.BeforeEach;
//import java.util.Set;
//import org.junit.Before;

public class TournamentTest {

    public List<Competitor> players;

    protected Competition createCompetition(List<Competitor> competitors) {
		return new MockTournament(competitors);
	}    


/* 
     @BeforeEach
    public void Before() {

        private static Tournament testTourmament  ;


        Competitor comp1 = new Competitor("France");
        Competitor comp2 = new Competitor("Algerie");
        Competitor comp3 = new Competitor("Italy");
        Competitor comp4 = new Competitor("maroc");


        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);


        testTourmament = new Tournament(players);
		testTourmament.setMatch(new MockMatch(testTourmament));
		testTourmament.play();

    }  */

    @Test
    public void playCreatesTheRightAmountOfMatchesPower2() {

        Competitor comp1 = new Competitor("France");
        Competitor comp2 = new Competitor("Algerie");
        Competitor comp3 = new Competitor("Italy");
        Competitor comp4 = new Competitor("Espagne");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);
        
        Tournament testTourmament = new Tournament(players);
		testTourmament.setMatch(new MockMatch(testTourmament));
		testTourmament.play();

		//int nb_competitors = testTourmament.getCompetitors().size();


		int target;
        MockTournament t = new MockTournament(players);
		target = testTourmament.getCompetitors().size() - 1;
		int value = t.getMatchCnt();
        
		testTourmament.play();
		assertEquals(target + value, t.getMatchCnt());
	}


	@Test
	public void playCreatesTheRightAmountOfMatchesNotPower2() throws RuntimeException {

        Competitor comp1 = new Competitor("France");

        players = new ArrayList<>();
        players.add(comp1);
        
        Tournament testTourmament = new Tournament(players);
		testTourmament.setMatch(new MockMatch(testTourmament));
		testTourmament.play();
	}
    

    @Test
    public void matchIsCorrectlyPlayed(){

        Competitor comp1 = new Competitor("Algerie");
        Competitor comp2 = new Competitor("France");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);

        Tournament testTourmament = new Tournament(players);
        testTourmament.setMatch(new MockMatch(testTourmament));
        testTourmament.play();

        int idxOfComp1 = players.indexOf(comp1);
        int scoreComp1 = testTourmament.ranking().get(players.get(idxOfComp1)) ;
        
        assertEquals(scoreComp1, 1);

    }

    private class MockTournament extends Tournament {

        private int match_cnt = 0;

        private MockTournament(List<Competitor> Competitors) {
            super(Competitors);
        }

        protected int getMatchCnt() {
            return this.match_cnt;
        }

        protected void setMatchCnt(int value) {
            this.match_cnt = value;
        }

        public void playMatch(Competitor c1, Competitor c2) {
            this.setMatchCnt(this.getMatchCnt() + 1);
            super.playMatch(c1, c2);

        }
    }
}
