package search;

import java.util.ArrayList;

public interface ISearchable {

    public AState getStartState();
    public AState getGoalState();

    public ArrayList<AState> getAllNeighbors(AState s);

    void setVisited(ISearchable s, AState source, boolean b);
    //AState getState();
}
