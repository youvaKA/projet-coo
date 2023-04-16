package competitions;

import java.util.ArrayList;
import java.util.List;
import competitions.competitors.Competitor;

/**
 * cette classe représente un type de compétition qui est PoolPhase
 * cette compétition est une sous classe de la classe Competition
 * elle a un nombre de groupes et une liste des League qui contient dans cette
 * PoolPhase
 * 
 * @author (Youva KAOUI)
 * @version (livrable 2)
 */

public class PoolPhase extends Competition {

    private int nbGroup;
    private List<League> leagueList;
    private Master master;

    public PoolPhase(List<Competitor> Competitors, int nbGroup) {
        super(Competitors);
        this.nbGroup = nbGroup;
        this.leagueList = new ArrayList<>();
    }

    public Master getMaster() {
        return this.master;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }

    public int getNbGroup() {
        return this.nbGroup;
    }

    // j'utilise le play match de competition pas utilise de redéfinir ici
    @Override
    protected void playMatch(Competitor c1, Competitor c2) {
    }

    // Finalement il n'est pas utile d'avoir un sertteur ici
    /*
     * public void setMatch(AbstractMatch match) {
     * this.match = match;
     * }
     */

    /**
     * the method will take a list given and divide it into smaller, equals pools
     * that will create a ranking base on the League competition mode. (another
     * child-class from Competition)
     * these leagues will be saved in a list.
     * 
     * @param players the list of competitors that will be seperated into pools.
     */

    @Override
    public void play(List<Competitor> players) {

        int size = players.size();
        Double divRes = Double.valueOf(size) / nbGroup;

        if (size % this.nbGroup != 0) {
            throw new RuntimeException("players size must be multiple of nbGroup");
        }

        if (size / this.nbGroup < 2) {
            throw new RuntimeException("minimun number of players must be greater");
        }

        int steps = divRes.intValue();
        for (int i = steps; i <= size; i += steps) {
            League tmp = new League(players.subList(i - steps, i));
            tmp.setMatch(this.getMatch());
            tmp.play();
            System.out.println("j'affiche le classement");
            System.out.println(tmp);
            leagueList.add(tmp);
        }

/*         // autre type d'algo, mais pas utiliser, je le laisse ici au besoins 
        // if (competitors.size()%nbGroup == 0){
        // for (i=0; i< nbGroup;i++) {
        // List<int> pool =
        // Competitors.subList(i*sizeCompetitors/nbGroup,(i+1)*sizeCompetitors/nbGroup);
        // leagueList[i] =
        // pool.play();
        // }
        // } */

    }

}
