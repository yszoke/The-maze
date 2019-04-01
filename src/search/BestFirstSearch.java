package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class BestFirstSearch extends BreadthFirstSearch implements ISearchingAlgorithm {
    int numOfEvaluated=0;
    @Override
    public ArrayList<AState> search(ISearchable s) {

        // performs a -first search of the maze
            ArrayList<AState> statesList =new ArrayList<AState>();

            AState source = s.getStartState();
            // our data structure T will be the maze itself
            // declares new queue
            PriorityQueue<AState> Q = new PriorityQueue<AState>(new costComparator());
            // pushes source to Q
            Q.offer(source);
            Q.comparator();

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
                ArrayList<AState> neighbors = s.getAllPossibleStates(current);
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
        } null;
    }



    @Override
    public String getName() {
        return "BestFirstSearch";
    }
}

class costComparator implements Comparator<AState>{

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(AState s1, AState s2) {

        if (s1.getCost() < s2.getCost())
            return 1;
        else if (s1.getCost() > s2.getCost())
            return -1;

        return 0;
    }
}
