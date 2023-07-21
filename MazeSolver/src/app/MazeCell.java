package app;


/**
 * The MazeCell class represents an open cell in a maze. Each cell knows its coordinates (row, col)
 * and keeps track of the next unchecked neighbor. A cell is considered "visited" once processing
 * moves to a neighboring cell. The visited variable is necessary so that a cell is not eligible for
 * visits from the cell just visited.
 */
public class MazeCell {
    private int row, col;
    // direction to check next (0: north, 1: east, 2: south, 3: west, 4: complete)
    private int direction;
    private boolean visited;

    /**
     * Constructs a MazeCell object with the given row and column coordinates.
     *
     * @param row The row coordinate of the cell.
     * @param col The column coordinate of the cell.
     */
    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
        direction = 0;
        visited = false;
    }

    /**
     * Constructs a MazeCell object with default row and column coordinates (-1, -1).
     * The direction is initialized to 0, and the cell is marked as unvisited.
     */
    public MazeCell() {
        this(-1, -1);
    }

    /**
     * Copy constructor for MazeCell objects.
     *
     * @param other The MazeCell object to copy.
     */
    public MazeCell(MazeCell other) {
        this.row = other.row;
        this.col = other.col;
        this.direction = other.direction;
        this.visited = other.visited;
    }

    /**
     * Gets the current direction to check next in the cell.
     *
     * @return The current direction (0: north, 1: east, 2: south, 3: west, 4: complete).
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Updates the direction. If direction is 4, marks the cell as visited.
     */
    public void advanceDirection() {
        direction++;
        if (direction == 4) {
            visited = true;
        }
    }

    /**
     * Sets the row and column coordinates of the cell.
     *
     * @param row The row coordinate of the cell.
     * @param col The column coordinate of the cell.
     */
    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Gets the row coordinate of the cell.
     *
     * @return The row coordinate.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column coordinate of the cell.
     *
     * @return The column coordinate.
     */
    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MazeCell other = (MazeCell) obj;
        return col == other.col && row == other.row;
    }

    /**
     * Marks the cell as visited.
     */
    public void visit() {
        visited = true;
    }

    /**
     * Resets the visited status of the cell.
     */
    public void reset() {
        visited = false;
    }

    /**
     * Checks if this cell is unvisited.
     *
     * @return True if the cell is unvisited, false otherwise.
     */
    public boolean unVisited() {
        return !visited;
    }
    
    

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}



