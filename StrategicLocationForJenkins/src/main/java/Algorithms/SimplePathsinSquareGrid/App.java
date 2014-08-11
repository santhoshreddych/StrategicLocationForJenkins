package Algorithms.SimplePathsinSquareGrid;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
        Grid grid ;
        long startTime;
           for(int input=2;input<5;input++){
            startTime= System.currentTimeMillis();
	        grid= new Grid(input);
            grid.findSimplePaths(startTime);
        
           }
}
}
