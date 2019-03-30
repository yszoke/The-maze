package algorithms.mazeGenerators;

import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int row, int col) {
        Maze maze = new Maze(row, col);
        //Position positions[][] = new Position[row][col];
        maze.initPositions(maze.positions);
        maze.setAllMaze(row, col, 1);
        Stack myPath=new Stack();
        Position current = new Position(maze.start.getRowIndex(), maze.start.getColumnIndex());
        maze.setMyMaze(current.getRowIndex(),current.getColumnIndex(),0);
        current.setVisited(true); //step 1
        while (maze.existNotVisited(maze.positions)) { //step 2
            if (maze.amountOfNeighbors(maze.positions,current) > 0) { //step 2.1
                Position next = maze.move(maze.positions, current,myPath); //step 2.1.1
                if(next.getColumnIndex()==maze.end.getColumnIndex()&&next.getRowIndex()==maze.end.getRowIndex()) {
                    break;
                }
                //myPath.push(current);//step 2.1.2
                maze.setMyMaze(next.getRowIndex(), next.getColumnIndex(), 0);//step 2.1.3
                current.setRow(next.getRowIndex()); //step 2.1.4
                current.setCol(next.getColumnIndex());
                current.setVisited(true);
            }
            else if (!myPath.empty()) { //step 2.2 : no more neighbors not visited and the stack is not empty
                Position temp1 = (Position)(myPath.pop());
                current.setRow(temp1.getRowIndex());
                current.setCol(temp1.getColumnIndex());
                current.setVisited(true);
            }
        }
        return maze;
    }

}
