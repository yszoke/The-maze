package search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    Maze maze;
    StateMaze StartState;
    StateMaze GoalState;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
        StartState = new StateMaze();
        GoalState = new StateMaze();
        StartState.setRow(maze.getStartPosition().getRowIndex());
        StartState.setCol(maze.getStartPosition().getColumnIndex());
        GoalState.setRow(maze.getGoalPosition().getRowIndex());
        GoalState.setCol(maze.getGoalPosition().getColumnIndex());
    }

    public StateMaze getStartState() {
        return StartState;
    }

    public StateMaze getGoalState() {
        return GoalState;
    }

    public ArrayList<AState> getAllPossibleStates(AState curr) {
        StateMaze current = (StateMaze) curr;
        ArrayList<AState> neighbors = new ArrayList<AState>();
        //ArrayList<AState> neighbors = new ArrayList<AState>();
        StateMaze north=new StateMaze(current.getRowIndex()-1, current.getColumnIndex());
        StateMaze northEast=new StateMaze(current.getRowIndex()-1, current.getColumnIndex()+1);
        StateMaze east=new StateMaze(current.getRowIndex(), current.getColumnIndex()+1);
        StateMaze southeast=new StateMaze(current.getRowIndex()+1, current.getColumnIndex()+1);
        StateMaze south=new StateMaze(current.getRowIndex()+1, current.getColumnIndex());
        StateMaze southwest=new StateMaze(current.getRowIndex()+1, current.getColumnIndex()-1);
        StateMaze west=new StateMaze(current.getRowIndex(), current.getColumnIndex()-1);
        StateMaze northwest=new StateMaze(current.getRowIndex()-1, current.getColumnIndex()-1);


        // checks North
        if (current.getRowIndex() > 0 && maze.getMyMaze(current.getRowIndex()-1, current.getColumnIndex()) == 0 &&
                maze.getVisited(current.getRowIndex()-1, current.getColumnIndex()) == false && !neighbors.contains(north)) {
            neighbors.add(new StateMaze(current.getRowIndex()-1, current.getColumnIndex(), current.distance + 1));
        }
        // checks North East
        if (current.getRowIndex() > 0 && current.getColumnIndex()<maze.getCol() - 1&&
                maze.getMyMaze(current.getRowIndex()-1, current.getColumnIndex()+1) == 0 &&
                maze.getVisited(current.getRowIndex()-1, current.getColumnIndex()+1) == false&& !neighbors.contains(northEast)&&
                (maze.getMyMaze(current.getRowIndex()-1, current.getColumnIndex()) == 0 || maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()+1) == 0)) {
            neighbors.add(new StateMaze(current.getRowIndex()-1, current.getColumnIndex()+1, current.distance + 1));
        }
        // checks East
        if (current.getColumnIndex()<maze.getCol() - 1 && maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()+1) == 0 &&
                maze.getVisited(current.getRowIndex(), current.getColumnIndex()+1) == false && !neighbors.contains(east)) {
            neighbors.add(new StateMaze(current.getRowIndex(), current.getColumnIndex()+1, current.distance + 1));
        }
        // checks South East
        if (current.getRowIndex()< maze.getRow() - 1 && current.getColumnIndex()<maze.getCol() - 1
                && maze.getMyMaze(current.getRowIndex()+1, current.getColumnIndex()+1) == 0 &&
                maze.getVisited(current.getRowIndex()+1, current.getColumnIndex()+1) == false && !neighbors.contains(southeast)&&
                (maze.getMyMaze(current.getRowIndex()+1, current.getColumnIndex()) == 0 || maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()+1) == 0)) {
            neighbors.add(new StateMaze(current.getRowIndex()+1, current.getColumnIndex()+1, current.distance + 1));
        }
        // checks South
        if (current.getRowIndex() < maze.getRow() - 1 && maze.getMyMaze(current.getRowIndex()+1, current.getColumnIndex()) == 0 &&
                maze.getVisited(current.getRowIndex() + 1, current.getColumnIndex()) == false && !neighbors.contains(south)) {
            neighbors.add(new StateMaze(current.getRowIndex()+1, current.getColumnIndex(), current.distance + 1));
        }
        // checks South West
        if (current.getRowIndex() < maze.getRow() - 1 && current.getColumnIndex()>0 &&
                maze.getMyMaze(current.getRowIndex()+1, current.getColumnIndex()-1) == 0 &&
                maze.getVisited(current.getRowIndex() + 1, current.getColumnIndex()-1) == false && !neighbors.contains(southwest) &&
                (maze.getMyMaze(current.getRowIndex()+1, current.getColumnIndex()) == 0 || maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()-1) == 0)) {
            neighbors.add(new StateMaze(current.getRowIndex()+1, current.getColumnIndex()-1, current.distance + 1));
        }
        // checks West
        if (current.getColumnIndex()>0 && maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()-1) == 0 &&
                maze.getVisited(current.getRowIndex(), current.getColumnIndex()-1) == false && !neighbors.contains(west)) {
            neighbors.add(new StateMaze(current.getRowIndex(), current.getColumnIndex()-1, current.distance + 1));
        }
        // checks North West
        if (current.getRowIndex()>0 && current.getColumnIndex()>0 &&
                maze.getMyMaze(current.getRowIndex()-1, current.getColumnIndex()-1) == 0 &&
                maze.getVisited(current.getRowIndex()-1, current.getColumnIndex()-1) == false && !neighbors.contains(northwest) &&
                (maze.getMyMaze(current.getRowIndex()-1, current.getColumnIndex()) == 0 || maze.getMyMaze(current.getRowIndex(), current.getColumnIndex()-1) == 0)) {
            neighbors.add(new StateMaze(current.getRowIndex()-1, current.getColumnIndex()-1, current.distance + 1));
        }

        return neighbors;
    }
    public void setVisited(ISearchable s, AState curr, boolean visit){
        ((SearchableMaze)s).maze.setVisited(((StateMaze)curr).getRowIndex(), ((StateMaze)curr).getColumnIndex(), visit);
    }
}
