package search;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BreadthFirstSearch implements ISearchingAlgorithm {
    int numOfEvaluated=0;

    @Override
    // performs a -first search of the maze
    public ArrayList<AState> search(ISearchable s) {
        ArrayList<AState> statesList =new ArrayList<AState>();

        AState source = s.getStartState();
        // our data structure T will be the maze itself
        // declares new queue
        Queue<AState> Q = new LinkedList<AState>();
        // pushes source to Q
        ((LinkedList<AState>) Q).offer(source);

        // marks source as visited

        //source.setVisited(true);
        s.setVisited(s, source,true);
        // enters main loop - checks if Q is nonempty
        while (Q.peek() != null) {
            // gets next element off of queue
            AState current = Q.poll();
            numOfEvaluated++;
            if (current.equals(s.getGoalState())) {
                statesList.add(current);
                //current = s.getGoalState();
                // if (maze[neighbor.xPos][neighbor.yPos] == 'x') {
                return statesList;
            }
            // gets neighbors of current
            ArrayList<AState> neighbors = s.getAllNeighbors(current);
            // iterates through set of all neighbors (nice java syntax)
            for (AState neighbor : neighbors) {
                // checks for exit
                neighbor.setParent(current);

                // we know every neighbor in neighbors is unvisited - why?
                Q.offer(neighbor);
                // marks neighbor as visited in array
                s.setVisited(s, neighbor, true);
                //neighbor.setVisited(true);
            }
        }
        // exit is not reachable
        return null;
    }

/*
    public int getNumOfVisitedNodes() {
        return numOfEvaluated;
    }
*/

    @Override
    public Solution solve(ISearchable domain) {
        AState goal=search(domain).get(0);
        Solution sol=new Solution(goal);
        return sol;
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfEvaluated;
    }
}
