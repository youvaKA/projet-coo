
import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;

import competitions.*;
import competitions.competitors.Competitor;

public class LeagueTest {


    public List<Competitor> players;

/*      @BeforeEach
     public void init() {

         Competitor comp1 = new Competitor("France");
         Competitor comp2 = new Competitor("Algerie");
         Competitor comp3 = new Competitor("&");
         Competitor comp4 = new Competitor("é");

         players = new ArrayList<>();
         players.add(comp1);
         players.add(comp2);
         players.add(comp3);
         players.add(comp4);

     } */

     
    @Test
    public void playCreatesTheRightAmountOfMatches() {

        Competitor comp1 = new Competitor("France");
        Competitor comp2 = new Competitor("Algerie");
        Competitor comp3 = new Competitor("Italy");
        Competitor comp4 = new Competitor("Espagne");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);

    
        MockLeague myLeague1 = new MockLeague( players);
        myLeague1.setMatch(new MockMatch(myLeague1));
        myLeague1.play();

        int nb_competitors = myLeague1.getCompetitors().size();
        int target = nb_competitors * (nb_competitors - 1);
        int value = myLeague1.getMatchCnt();

        myLeague1.play();
        assertEquals(target + value, myLeague1.getMatchCnt());


    }

    @Test
    public void playIsCorrectlyPlayed(){

        Competitor comp1 = new Competitor("Algerie");
        Competitor comp2 = new Competitor("France");
        Competitor comp3 = new Competitor("Italie");
        Competitor comp4 = new Competitor("Espagne");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);

        MockLeague myLeague = new MockLeague(players);
        myLeague.setMatch(new MockMatch(myLeague));
        myLeague.play();

        int idxOfComp1 = players.indexOf(comp1);
        int scoreComp1 = myLeague.ranking().get(players.get(idxOfComp1));
        int idxOfComp2 = players.indexOf(comp2);
        int scoreComp2 = myLeague.ranking().get(players.get(idxOfComp2));
        int idxOfComp3 = players.indexOf(comp3);
        int scoreComp3 = myLeague.ranking().get(players.get(idxOfComp3));
        int idxOfComp4 = players.indexOf(comp4);
        int scoreComp4 = myLeague.ranking().get(players.get(idxOfComp4));
        int sumScores = scoreComp1 + scoreComp2 + scoreComp3 + scoreComp4;
        
        assertEquals(sumScores, 12);

    }

    @Test
    public void playIsOrderedByScores(){

        Competitor comp1 = new Competitor("Algerie");
        Competitor comp2 = new Competitor("France");
        Competitor comp3 = new Competitor("Italie");
        Competitor comp4 = new Competitor("Espagne");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);

        MockLeague myLeague = new MockLeague(players);
        myLeague.setMatch(new MockMatch(myLeague));
        myLeague.play();

        int idxOfComp1 = players.indexOf(comp1);
        int scoreComp1 = myLeague.ranking().get(players.get(idxOfComp1));
        int idxOfComp2 = players.indexOf(comp2);
        int scoreComp2 = myLeague.ranking().get(players.get(idxOfComp2));
        int idxOfComp3 = players.indexOf(comp3);
        int scoreComp3 = myLeague.ranking().get(players.get(idxOfComp3));
        int idxOfComp4 = players.indexOf(comp4);
        int scoreComp4 = myLeague.ranking().get(players.get(idxOfComp4));
        
        assertTrue(scoreComp1 >= scoreComp2 && scoreComp2 >= scoreComp3 && scoreComp3 >= scoreComp4);

    }

/*     @Test
    public void playRunsCorrectly(){

        Competitor comp1 = new Competitor("Algerie");
        Competitor comp2 = new Competitor("France");
        Competitor comp3 = new Competitor("Italie");
        Competitor comp4 = new Competitor("Espagne");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        players.add(comp4);

        MockLeague myLeague = new MockLeague(players);
        myLeague.setMatch(new MockMatch(myLeague));
        myLeague.play();

        int idxOfComp1 = players.indexOf(comp1);
        int scoreComp1 = myLeague.ranking().get(players.get(idxOfComp1));
        int idxOfComp2 = players.indexOf(comp2);
        int scoreComp2 = myLeague.ranking().get(players.get(idxOfComp2));
        int idxOfComp3 = players.indexOf(comp3);
        int scoreComp3 = myLeague.ranking().get(players.get(idxOfComp3));
        int idxOfComp4 = players.indexOf(comp4);
        int scoreComp4 = myLeague.ranking().get(players.get(idxOfComp4));
        int sumScores = scoreComp1 + scoreComp2 + scoreComp3 + scoreComp4;
        
        assertTrue(scoreComp1 == 1 && scoreComp2 == 1 && scoreComp3 == 1 && scoreComp4 == 1 && sumScores == 6);

    }
 */

    @Test
    public void matchIsCorrectlyPlayed(){

        Competitor comp1 = new Competitor("Algerie");
        Competitor comp2 = new Competitor("France");

        players = new ArrayList<>();
        players.add(comp1);
        players.add(comp2);

        League myLeague = new League(players);
        myLeague.setMatch(new MockMatch(myLeague));
        myLeague.play();

        int idxOfComp1 = players.indexOf(comp1);
        int scoreComp1 = myLeague.ranking().get(players.get(idxOfComp1)) ;
        
        assertEquals(scoreComp1, 1);

    }

    private class MockLeague extends League {
        private int match_cnt = 0;

        public MockLeague(List<Competitor> Competitors) {
            super(Competitors);
        }

        protected int getMatchCnt() {
            return this.match_cnt;
        }

        protected void setMatchCnt(int value) {
            this.match_cnt = value;
        }

        @Override
        public void playMatch(Competitor c1, Competitor c2) {
            this.setMatchCnt(this.getMatchCnt() + 1);

            super.playMatch(c1, c2);
        }

    }
}