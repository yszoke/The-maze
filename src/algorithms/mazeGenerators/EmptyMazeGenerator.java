package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int row, int col) {

        Maze maze = new Maze(row, col);
        /*for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                maze.setMyMaze(i,j,0);
            }
        }*/
        //System.out.println(maze);
        return maze;


    }

}
