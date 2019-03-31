package search;

public class State {

    int row;
    int col;
    boolean partOfPath;
    int value;
    int distance;

    public State() {
        this.row = 0;
        this.col = 0;
        this.partOfPath=false;
        this.value=1;
        this.distance=0;
    }

    public State(int row, int col) {
        this.row = row;
        this.col = col;
        this.partOfPath=false;
        this.value=1;
    }

    public void setRow(int row) {this.row = row; }
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

    public int getRowIndex() {
        return row;
    }
    public int getColumnIndex() {
        return col;
    }
    public int getDistance() { return distance; }
    public int getValue() { return value; }
    public boolean getPartOfPath() { return partOfPath; }

    @Override
    public String toString() {
        return "{"+ row +","+ col+"}";
    }
}



