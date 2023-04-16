
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitions.*;
import competitions.competitors.Competitor;
import competitions.matches.RandomMatch;

public class PoolPhaseTest {

    private List<Competitor> evenlist;
    private PoolPhase pool;
    private int nbGroup = 2;

    @BeforeEach
    public void init() {

        Competitor Earth = new Competitor("Earth");
        Competitor Mars = new Competitor("Mars");
        Competitor Mercury = new Competitor("Mercury");
        Competitor Venus = new Competitor("Venus");

        this.evenlist = new ArrayList<>();
        this.evenlist.add(Earth);
        this.evenlist.add(Mars);
        this.evenlist.add(Mercury);
        this.evenlist.add(Venus);

        this.pool = new PoolPhase(this.evenlist, nbGroup);
        this.pool.setMatch(new RandomMatch(this.pool));

    }

/*     @Test
    void playThrowsRuntimeExceptionWhenTryingToCreatInequalGroups() throws RuntimeException {
        nbGroup = 3;
        pool.play(evenlist);
        Assertions.assertThrows(RuntimeException.class, () -> {
        });
    } */
/* 
    @Test
    void minimNumberPlayersThrowsRuntimeException() throws RuntimeException {
        nbGroup = 1;
        Assertions.assertThrows(RuntimeException.class, () -> {
            pool.play(evenlist);
        });
    } */

    @Test

    void leagueListeBeforePlayIsEmpty() {
        Assertions.assertTrue(pool.getLeagueList().size() == 0);
    }

    @Test

    void dplayThrowsRuntimeExceptionWhenTryingToCreatInequalGroups() throws RuntimeException {
        nbGroup = 3;
        pool.play(evenlist);

    }

    @Test
    void minimNumberPlayers() throws RuntimeException {
        nbGroup = 1;
        pool.play(evenlist);
    }

}