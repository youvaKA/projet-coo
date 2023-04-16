package competitions.strategies;

import java.util.List;

import competitions.Master;
//import competitions.PoolPhase;
import competitions.competitors.Competitor;

public interface Strategies {

    //public List<Competitor> getStageTwoPlayers(PoolPhase pools);
    public List<Competitor> getFinalCompetitors();

    public void setMaster (Master master);

    public Master getMaster();
} 
