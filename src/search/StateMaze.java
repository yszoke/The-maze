package search;

public class StateMaze extends AState {

    int row;
    int col;
    boolean partOfPath;
    boolean visited;
    int value;
    int distance;

    public StateMaze() {
        this.row = 0;
        this.col = 0;
        this.partOfPath=false;
        this.value=1;
        this.distance=0;
    }

    public StateMaze(int row, int col) {
        this.row = row;
        this.col = col;
        this.partOfPath=false;
        this.value=1;
        this.visited = false;
    }


    public StateMaze(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.distance = dis;
    }

    public void setRow(int row) {
        this.row = row; }
    public void setCol(int col) {
        this.col = col;
    }
    public void setValue(int val) {
        this.value = val;
    }
    public void setPartOfPath(boolean isPart) {
        this.partOfPath = isPart;
    }
    public void setDistance(int dis) {
        this.distance = dis;
    }
    public void setVisited(boolean visit) { this.visited = visit;
    }

    public int getRowIndex() {
        return row;
    }
    public int getColumnIndex() {
        return col;
    }
    public int getDistance() { return distance; }
    public int getValue() { return value; }
    public boolean getPartOfPath() { return partOfPath; }
    public boolean getVisited() { return visited; }

    @Override
    public boolean equals(Object obj) {
        return (this.row==((StateMaze)obj).getRowIndex() &&  this.col==((StateMaze)obj).getColumnIndex());

    }

    @Override
    public String toString() {
        return "{"+ row +","+ col+"}";
    }
}



