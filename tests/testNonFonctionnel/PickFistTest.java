package testNonFonctionnel;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import competitions.strategies.PickFirst;
import competitions.competitors.Competitor;
import competitions.Master;

class PickFirstTest {

    @Test
    void testGetFinalCompetitors() {
        List<Competitor> competitors = new ArrayList<Competitor>();
        competitors.add(new Competitor("C1"));
        competitors.add(new Competitor("C2"));
        competitors.add(new Competitor("C3"));
        competitors.add(new Competitor("C4"));

        Master master = new Master(competitors, 2, new PickFirst());
        master.play(competitors);

        List<Competitor> expectedCompetitors = new ArrayList<Competitor>();
        expectedCompetitors.add(new Competitor("C1"));
        expectedCompetitors.add(new Competitor("C2"));

        assertEquals(master.strategie.getFinalCompetitors(), expectedCompetitors);
    }

}
