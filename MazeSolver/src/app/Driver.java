package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack; // Import Stack

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        // Read the maze from the file
        File inputFile = new File("Maze.txt");
        Scanner fin = new Scanner(inputFile);

        int rows = fin.nextInt();
        int cols = fin.nextInt();

        // Create the maze grid
        int[][] grid = new int[rows][cols];

        // Read in the data from the file to populate the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = fin.nextInt();
            }
        }
        fin.close();

        // Print the maze
        printMaze(grid);

        // Create a 2D array of MazeCell objects
        MazeCell[][] cells = new MazeCell[rows][cols];

        // Populate with MazeCell objects - default object for walls
        MazeCell start = new MazeCell(), end = new MazeCell();

        // Iterate over the grid, make cells, and set coordinates
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Make a new cell
                cells[i][j] = new MazeCell();

                // If it isn't a wall, set the coordinates
                if (grid[i][j] != 0) {
                    cells[i][j].setCoordinates(i, j);

                    // Look for the start and end cells
                    if (grid[i][j] == 3) {
                        start = cells[i][j];
                    } else if (grid[i][j] == 4) {
                        end = cells[i][j];
                    }
                }
            }
        }

        // Testing
        System.out.println("Start: " + start + " End: " + end);

        // Solve the maze using depth-first search
        depthFirst(start, end, cells); // Pass the cells array
    }

    public static void depthFirst(MazeCell start, MazeCell end, MazeCell[][] cells) {
        // Create a stack to store the visited cells
        Stack<MazeCell> stack = new Stack<>();
        // Push the start cell onto the stack
        stack.push(start);

        // Keep track of the path from start to end
        ArrayList<MazeCell> path = new ArrayList<>();
        

        // Iterate until the stack is empty (no more cells to visit)
        while (!stack.isEmpty()) {
            // Get the current cell from the top of the stack
            MazeCell currentCell = stack.peek();
            System.out.println("Current Cell: " + currentCell);

            // If the current cell is the end cell, the path is found
            if (currentCell.equals(end)) {
                // Add the end cell to the path
                path.add(currentCell);
                System.out.println("Path found!");
                // Print the path
                printPath(path);
                return;
            }

            // Find the next unvisited neighbor of the current cell
            MazeCell nextCell = findNextNeighbor(currentCell, cells); // Pass the cells array
            System.out.println("Next Cell: " + nextCell);

            if (nextCell != null) {
                // Mark the next cell as visited
                nextCell.visit();
                // Add the current cell to the path
                path.add(currentCell);
                // Push the next cell onto the stack
                stack.push(nextCell);
            } else {
                // If no unvisited neighbor, backtrack
                stack.pop();
                // Remove the current cell from the path (backtrack)
                path.remove(path.size() - 1);
            }
        }

        // If the stack is empty and no path is found
        System.out.println("No path found!");
    }

    
    private static MazeCell findNextNeighbor(MazeCell cell, MazeCell[][] cells) {
        int row = cell.getRow();
        int col = cell.getCol();

        // Define the order to check neighbors (North, East, South, West)
        int[] rowOffsets = { -1, 0, 1, 0 };
        int[] colOffsets = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (newRow >= 0 && newRow < cells.length && newCol >= 0 && newCol < cells[0].length) {
                MazeCell neighbor = cells[newRow][newCol];
                if (neighbor != null && neighbor.unVisited()) {
                    return neighbor;
                }
            }
        }

        // If no unvisited neighbor, return null
        return null;
    }


    private static void printPath(ArrayList<MazeCell> path) {
        // Print the sequence of coordinates from start to end
        System.out.print("Path: ");
        for (MazeCell cell : path) {
            System.out.print("(" + cell.getRow() + "," + cell.getCol() + ") ");
        }
        System.out.println();
    }

    public static void printMaze(int[][] grid) {
        // Print the maze
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 3) {
                    System.out.print("S ");
                } else if (cell == 4) {
                    System.out.print("E ");
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
}




