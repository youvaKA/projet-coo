
import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import competitions.competitors.Competitor;

import java.util.Arrays;
import java.util.List;

import competitions.observers.Bookmaker;

public class BookmakerTest {
    private Bookmaker bookmaker;
    private Competitor competitor1;
    private Competitor competitor2;
    private Competitor competitor3;
    private List<Competitor> competitors;

    @BeforeEach
    public void setup() {
        competitor1 = new Competitor("Player 1");
        competitor2 = new Competitor("Player 2");
        competitor3 = new Competitor("Player 3");
        competitors = Arrays.asList(competitor1, competitor2, competitor3);
        bookmaker = new Bookmaker("b1",competitors);
    }

    @Test
        
    
    public void testInitialOdds() {
        Assertions.assertEquals(3, bookmaker.getOdd(competitor1));
        Assertions.assertEquals(3, bookmaker.getOdd(competitor2));
        Assertions.assertEquals(3, bookmaker.getOdd(competitor3));
    }

    @Test
    public void testIncrementOdd() {
        bookmaker.incrementOdd(competitor1);
        assertEquals(4, bookmaker.getOdd(competitor1));
        assertEquals(3, bookmaker.getOdd(competitor2));
        assertEquals(3, bookmaker.getOdd(competitor3));
    }

    @Test
    public void testDecrementOdd() {
        bookmaker.decrementOdd(competitor1);
        assertEquals(2, bookmaker.getOdd(competitor1));
        assertEquals(3, bookmaker.getOdd(competitor2));
        assertEquals(3, bookmaker.getOdd(competitor3));
    }

    @Test
    public void testDecrementOddBelowMinimum() {
        bookmaker.decrementOdd(competitor1);
        bookmaker.decrementOdd(competitor1);
        assertEquals(1, bookmaker.getOdd(competitor1));
        assertEquals(3, bookmaker.getOdd(competitor2));
        assertEquals(3, bookmaker.getOdd(competitor3));
    }

      @Test
    public void testDisplay() {
        bookmaker.display(competitor1, competitor2);
        assertEquals(2, bookmaker.getOdd(competitor1));
        assertEquals(4, bookmaker.getOdd(competitor2));
        assertEquals(3, bookmaker.getOdd(competitor3));
    }  
}