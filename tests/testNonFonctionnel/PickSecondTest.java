package testNonFonctionnel;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competitions.Master;
import competitions.competitors.Competitor;
import competitions.strategies.PickSecond;

public class PickSecondTest {
	
	@Test
	public void testGetFinalCompetitors() {
		Competitor c1 = new Competitor("Paris");
		Competitor c2 = new Competitor( "Marseille");
		Competitor c3 = new Competitor( "Lyon");
		Competitor c4 = new Competitor("Toulouse");
		Competitor c5 = new Competitor("Bordeaux");
		Competitor c6 = new Competitor( "Nice");
		
		List<Competitor> competitorsList = new ArrayList<>();
		competitorsList.add(c1);
		competitorsList.add(c2);
		competitorsList.add(c3);
		competitorsList.add(c4);
		competitorsList.add(c5);
		competitorsList.add(c6);
		
        Master master = new Master(competitorsList, 3, new PickSecond());
		
		List<Competitor> expectedList = new ArrayList<>();
		expectedList.add(c1);
		expectedList.add(c4);
		
		List<Competitor> actualList = master.strategie.getFinalCompetitors();
		
		assertEquals(expectedList, actualList);
	}

}