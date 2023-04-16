
import java.util.ArrayList;
import java.util.List;

import competitions.League;
import competitions.Master;
import competitions.Tournament;
import competitions.competitors.Competitor;
import competitions.matches.RandomMatch;
import competitions.observers.Bookmaker;
import competitions.observers.Journaliste;
import competitions.strategies.PickFirst;
import competitions.strategies.PickSecond;
import competitions.strategies.pickTwoThird;

public abstract class Main {
	
	
	public static void main(String[] args) {
		
		List<Competitor> players1 = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			players1.add(new Competitor("Equipe"+i));			
		}

		Competitor comp1 = new Competitor("Blastoff");
		Competitor comp2 = new Competitor("Drift");
		Competitor comp3 = new Competitor("Lynx");
		Competitor comp4 = new Competitor("Raven");
		Competitor comp5 = new Competitor("Catalyst");
		Competitor comp6 = new Competitor("Midas");
		Competitor comp7 = new Competitor("Map");
		Competitor comp8 = new Competitor("Blastoff");

		ArrayList<Competitor> players = new ArrayList<>();
		players.add(comp1);
        players.add(comp2);
		players.add(comp3);
        players.add(comp4);
		players.add(comp5);
        players.add(comp6);
		players.add(comp7);
		players.add(comp8); 

		String newLine = System.getProperty("line.separator");
		System.out.println(newLine);

/* 		League myLeague1 = new League(players);
		myLeague1.setMatch(new RandomMatch(myLeague1));
		myLeague1.play();
		System.out.println(myLeague1); */

/* 		Tournament testTourmament = new Tournament(players);
		testTourmament.setMatch(new RandomMatch(testTourmament));
		testTourmament.play();
		System.out.println(testTourmament); */
		

		//PickFirst
		System.out.println( "DEBUT D'UNE COMPETITION MASTER AVEC LA STRATEGIE PickFirst ");
		Master master3 = new Master(players, 2, new PickFirst());
		master3.setMatch(new RandomMatch(master3));
		Journaliste lequipe21 = new Journaliste("l'equipe21",players);
		master3.iWantToObserve(lequipe21);
		Bookmaker Betclick = new Bookmaker("Betclick",players);
		master3.iWantToObserve(Betclick); 
		master3.play();
		System.out.println(master3);  
		
		//PickSecond
		System.out.println( "DEBUT D'UNE COMPETITION MASTER AVEC LA STRATEGIE PickSecond ");
		Master master1 = new Master(players, 2, new PickSecond());
		master1.setMatch(new RandomMatch(master1));
		Bookmaker Winamax = new Bookmaker("Winamax",players);
		master1.iWantToObserve(Winamax);
		Journaliste sportDirect = new Journaliste("sportDirect",players);
		master3.iWantToObserve(sportDirect);
		master1.play();
		System.out.println(master1); 
		

		//mauvais affichage + erreure, probleme du à la strategies, il y un joueur suplémentaire donc le bookmaker ne sais pas l'affichier.
/*  	Master master2 = new Master(players1, 3, new pickTwoThird());
		master2.setMatch(new RandomMatch(master2));
		Bookmaker Winamax = new Bookmaker("Winamax",players);
		master2.iWantToObserve(Winamax);
		master2.play();
		System.out.println(master2); 
  */
	}

}