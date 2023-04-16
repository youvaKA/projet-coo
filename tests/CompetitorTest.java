
import static org.junit.Assert.*;
import org.junit.Test;

import competitions.competitors.Competitor;

public class CompetitorTest {

    @Test
    public void testNameOfCompetitors() {
        Competitor comp1 = new Competitor("Losc");
        assertEquals(comp1.getName(), "Losc");
    }
}
