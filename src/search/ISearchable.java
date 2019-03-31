package search;

import java.util.ArrayList;

public interface ISearchable {

    AState getStartState();
    AState getGoalState();
    ArrayList<AState> getAllNeighbors(AState s);
    //AState getState();
}
