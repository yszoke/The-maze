package search;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements ISearchingAlgorithm {

    @Override
    // performs a -first search of the maze
    public AState search(ISearchable s) {
            AState source=s.getStartState();
            // our data structure T will be the maze itself
            // declares new queue
            Queue<AState> Q = new LinkedList<AState>();
            // pushes source to Q
        ((LinkedList<AState>) Q).addLast(source);

            // marks source as visited
            maze[source.][source.yPos] = '#';
            // enters main loop - checks if Q is nonempty
            while (Q.peek() != null) {
                // gets next element off of queue
                StateMaze current = Q.poll();
                // gets neighbors of current
                ArrayList<StateMaze> neighbors = getNeighbors(maze, current);
                // iterates through set of all neighbors (nice java syntax)
                for (StateMaze neighbor : neighbors) {
                    // checks for exit
                    if (maze[neighbor.xPos][neighbor.yPos] == 'x') {
                        return neighbor.dist;
                    }
                    // we know every neighbor in neighbors is unvisited - why?
                    Q.offer(neighbor);
                    // marks neighbor as visited in array
                    maze[neighbor.xPos][neighbor.yPos] = '#';
                }
            }
            // exit is not reachable
            return 0;
        }
    }
}
