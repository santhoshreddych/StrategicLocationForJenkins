package Algorithms.SimplePathsinSquareGrid;

public class Coordinates {
	private int x = -1;
        private int y=-1;
	private boolean used = false;
	private Coordinates topNeighbour = null;
	private Coordinates rightNeighbour = null;
	private Coordinates bottomNeighbour = null;
	private Coordinates leftNeighbour = null;

	public Coordinates(int x,int y) {
		this.x = x;
                this.y=y;
	}

	public Coordinates getTopNeighbour() {
		return topNeighbour;
	}

	public void setTopNeighbour(Coordinates topNeighbour) {
		this.topNeighbour = topNeighbour;
	}

	public Coordinates getRightNeighbour() {
		return rightNeighbour;
	}

	public void setRightNeighbour(Coordinates eastNeighbour) {
		this.rightNeighbour = eastNeighbour;
	}

	public Coordinates getBottomNeighbour() {
		return bottomNeighbour;
	}

	public void setBottomNeighbour(Coordinates bottomNeighbour) {
		this.bottomNeighbour = bottomNeighbour;
	}

	public Coordinates getLeftNeighbour() {
		return leftNeighbour;
	}

	public void setLeftNeighbour(Coordinates leftNeighbour) {
		this.leftNeighbour = leftNeighbour;
	}

	public boolean isTraversed() {
		return used;
	}

	public void markTraversed() {
		used = true;
	}

	public void removeTraversedMark() {
		used = false;
	}

	@Override
	public String toString() {
	//	return Integer.toString(id);
            String s="("+x+","+y+")";
            return s;
	}
}