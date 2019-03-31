package search;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BreadthFirstSearch implements ISearchingAlgorithm {
    int numOfVisited=0;

    @Override
    // performs a -first search of the maze
    public int search(ISearchable s) {
        AState source = s.getStartState();
        // our data structure T will be the maze itself
        // declares new queue
        Queue<AState> Q = new LinkedList<AState>();
        // pushes source to Q
        ((LinkedList<AState>) Q).offer(source);

        // marks source as visited

        source.setVisited(true);
        // enters main loop - checks if Q is nonempty
        while (Q.peek() != null) {
            // gets next element off of queue
            AState current = Q.poll();
            numOfVisited++;
            // gets neighbors of current
            ArrayList<AState> neighbors = s.getAllNeighbors(current);
            // iterates through set of all neighbors (nice java syntax)
            for (AState neighbor : neighbors) {
                // checks for exit
                if (current.equals(s.getGoalState())) {
                    // if (maze[neighbor.xPos][neighbor.yPos] == 'x') {
                    return neighbor.getDistance();
                }
                // we know every neighbor in neighbors is unvisited - why?
                Q.offer(neighbor);
                // marks neighbor as visited in array
                neighbor.setVisited(true);
            }
        }
        // exit is not reachable
        return 0;
    }


    public int getNumOfVisitedNodes() {
        return numOfVisited;
    }


}
