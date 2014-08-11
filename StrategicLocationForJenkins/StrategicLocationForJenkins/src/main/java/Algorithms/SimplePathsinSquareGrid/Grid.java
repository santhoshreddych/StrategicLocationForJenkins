package Algorithms.SimplePathsinSquareGrid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private Coordinates[][] coordinates = null;
	private Coordinates startCoordinate = null;
	private Coordinates targetCoordinate = null;
        private int count=0;
        int gridsize=0;

	public Grid(int sideLength) {
            gridsize=sideLength-1;
		coordinates = new Coordinates[sideLength][sideLength];
		for (int row = 0; row < coordinates.length; row++) {
			for (int col = 0; col < coordinates[row].length; col++) {
				coordinates[row][col] = new Coordinates(row,col);
			}
		}

		startCoordinate = coordinates[0][0]; //bottom left coordinates
		targetCoordinate = coordinates[sideLength-1][sideLength-1]; // top right coordinates



		linkPixels(coordinates);
	}

	protected static void linkPixels(Coordinates[][] coordinates) {
         // This method creates a adjacency matrix in order to define the neighbours for each and every vertex in the grid
		for (int row = 0; row < coordinates.length; row++) {
			for (int col = 0; col < coordinates[row].length; col++) {
				if (row - 1 >= 0) {
					coordinates[row][col].setTopNeighbour(coordinates[row - 1][col]);
				}
				if (col + 1 < coordinates[row].length) {
					coordinates[row][col].setRightNeighbour(coordinates[row][col + 1]);
				}
				if (row + 1 < coordinates.length) {
					coordinates[row][col].setBottomNeighbour(coordinates[row + 1][col]);
				}
				if (col - 1 >= 0) {
					coordinates[row][col].setLeftNeighbour(coordinates[row][col - 1]);
				}
			}
		}
	}

	private void findSimplePath(List<Coordinates> path, Coordinates pathCoordinate) {
		if (pathCoordinate == null || pathCoordinate.isTraversed())
			return;

		path.add(pathCoordinate);

		if (pathCoordinate == targetCoordinate) {
                        printPath(path);
                        path.remove(path.size() - 1);
			return;
		}

		pathCoordinate.markTraversed();
		findSimplePath(path, pathCoordinate.getTopNeighbour());
		findSimplePath(path, pathCoordinate.getRightNeighbour());
		findSimplePath(path, pathCoordinate.getBottomNeighbour());
		findSimplePath(path, pathCoordinate.getLeftNeighbour());

		pathCoordinate.removeTraversedMark();
		path.remove(path.size() - 1);
                
                
	}

	public void findSimplePaths(long startTime) {
		List<Coordinates> path = new ArrayList();
		findSimplePath(path, startCoordinate);
                long endTime = System.currentTimeMillis();
                System.out.println("Number of simple Paths from (0,0) to ("+gridsize+","+gridsize+") are "+count+" and time taken is "+ (endTime - startTime) + " milliseconds");
	}

	private void printPath(List<Coordinates> path) {
                count= count+1;
                /* uncommenting this below line would print  all the simple paths from (0,0) to (n-1,n-1). Commenting this would make the progam much fasters
		
                System.out.println(path); 
                        
                        */
	}
	
}
