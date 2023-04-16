package competitions.matches;
import competitions.observers.Observers;


public interface MatchObservables {
    
    public void addObserver(Observers o);
    public void removeObserver(Observers o);
    
}
