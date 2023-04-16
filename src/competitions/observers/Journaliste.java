package competitions.observers;

import java.util.List;

import competitions.competitors.Competitor;

public class Journaliste implements Observers {
    public String name;
    public List<Competitor> compts;

    public Journaliste(String name, List<Competitor> competitors) {
        this.name = name;
        this.compts = competitors;
    }

    @Override
    public void display(Competitor winner, Competitor looser) {
        System.out.println("\n -------ACTUALITE SPORTIVE-------");
        System.out.println(name + " est fière de vous présenter l'actualité sportive.\n");
        System.out.println("Dans ce match opposant " + winner + " à " + looser);
        System.out.println( winner + " arrache la victoire, quant à " + looser + " est définitivement au fond du trou" );
    }
    
}
