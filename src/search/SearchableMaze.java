package search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    Maze maze;
    StateMaze StartState;
    StateMaze GoalState;

    public SearchableMaze(Maze maze) {
        this.maze=maze;
        StartState.setRow(maze.getStartPosition().getRowIndex());
        StartState.setCol(maze.getStartPosition().getColumnIndex());
        GoalState.setRow(maze.getStartPosition().getRowIndex());
        GoalState.setCol(maze.getStartPosition().getColumnIndex());
    }

    public StateMaze getStartState(){
        return StartState;
    }
    public StateMaze getGoalState(){
        return GoalState;
    }
    public ArrayList<StateMaze> getAllNeighbors(StateMaze current) {
        ArrayList<StateMaze> neighbors = new ArrayList<StateMaze>();
        // checks North
        if (current.getColumnIndex() > 0 && maze.getMyMaze(current.getRowIndex(), current.getColumnIndex() - 1) == 0 &&
                maze.getVisited(current.getRowIndex(), current.getColumnIndex() - 1) == false) {
            neighbors.add(new StateMaze(current.getRowIndex(), current.getColumnIndex() - 1, current.distance + 1));
        }
        // checks East
        if (current.getRowIndex() < maze.getCol() - 1 && maze.getMyMaze(current.getRowIndex() + 1, current.getColumnIndex()) == 0 &&
                maze.getVisited(current.getRowIndex() + 1, current.getColumnIndex()) == false){
            neighbors.add(new StateMaze(current.getRowIndex() + 1, current.getColumnIndex(), current.distance + 1));
        }
        // checks South
        if (current.getColumnIndex() < maze.getRow()-1 && maze.getMyMaze(current.getRowIndex(),current.getColumnIndex()+1) == 0 &&
        maze.getVisited(current.getRowIndex() + 1, current.getColumnIndex()) == false){
            neighbors.add(new StateMaze(current.getRowIndex(), current.getColumnIndex()+1, current.distance+1));
        }
        // checks West
        if (current.getRowIndex() > 0 && maze.getMyMaze(current.getRowIndex()-1,current.getColumnIndex()) == 0 &&
                maze.getVisited(current.getRowIndex() + 1, current.getColumnIndex()) == false) {
            neighbors.add(new StateMaze(current.getRowIndex()-1, current.getColumnIndex(), current.distance+1));
        }
        return neighbors;
        }


}
