Maze Solver

The Maze Solver is a Java program that uses depth-first search algorithm to find a path from the start point (S) to the end point (E) in a given maze. The maze is represented as a 2D grid, where walls are denoted by 0, open paths by 1, the start point by 3, and the end point by 4.

How to Use

Ensure you have Java installed on your computer.
Clone or download this repository to your local machine.
Create a text file named "Maze.txt" in the root directory of the project and populate it with your maze data. The first two integers in the file should represent the number of rows and columns in the maze, followed by the maze grid.
Example maze content:
Copy code
5 5
1 0 0 1 1
0 1 1 1 0
1 0 0 1 1
0 1 1 0 0
3 0 1 0 4
In this example, the maze is a 5x5 grid with the start point (S) at row 4, column 1, and the end point (E) at row 4, column 3.
Compile and run the Driver.java file to execute the Maze Solver algorithm.
The program will display the maze grid with the path from the start point to the end point marked by "-" for horizontal movements and "|" for vertical movements.
If a path is found, the program will also print the sequence of coordinates (row, col) representing the path.
Customizing the Maze

You can create different mazes by modifying the content of the "Maze.txt" file. Make sure to follow the same format, where walls are denoted by 0, open paths by 1, start point by 3, and end point by 4.

Implementation Details

The Maze Solver program uses a depth-first search algorithm to find a path from the start point to the end point in the maze. It utilizes a stack to keep track of the visited cells and a 2D array of MazeCell objects to represent the maze grid. The MazeCell class contains information about the row, column, and whether the cell has been visited or not. The depthFirst method explores the maze, backtracks when it reaches dead ends, and marks the path using "-" for horizontal movements and "|" for vertical movements.

Feel free to use this Maze Solver as a reference or starting point for your maze-solving projects!

Author

The Maze Solver program was developed by [Your Name]. If you have any questions or suggestions, please feel free to reach out to [your_email@example.com].
