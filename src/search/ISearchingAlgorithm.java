package search;

import java.util.ArrayList;

public interface ISearchingAlgorithm {

    ArrayList<AState> search(ISearchable s );
    //int getNumOfVisitedNodes();
    Solution solve(ISearchable domain);
    String getName();
    int getNumberOfNodesEvaluated();
}
