/**
 * Package
 * test 1233
 */
package lab4.data;

import java.util.Observable;

/**
 * Represents the 2-d game grid
 * @author Leo,Oscar
 */

public class GameGrid extends Observable {

	/**
	 * value for if the space is empty
	 */
	public static final int EMPTY = 0;
	/**
	 * value for if the space is occupied by the player ME
	 */
	public static final int ME = 1;
	/**
	 * value for if the space is occupied by the player OTHER
	 */
	public static final int OTHER = 2;
	private static final int INROW = 3;
	private int size;
	private int[][] boards;

	/**
	 * Constructor
	 * 
	 * @param size The width/height of the game grid
	 */
	public GameGrid(int size) {
		this.size = size;
		this.boards = new int[this.size][this.size];
		clearGrid();

	}

	/**
	 * Reads a location of the grid
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return the value of the specified location
	 */
	public int getLocation(int x, int y) {
		return boards[x][y];
	}

	/**
	 * Returns the size of the grid
	 * 
	 * @return the grid size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Enters a move in the game grid
	 * 
	 * @param x      the x position
	 * @param y      the y position
	 * @param player the player id
	 * @return true if the insertion worked, false otherwise
	 */
	public boolean move(int x, int y, int player) {
		try {
			if (boards[x][y] == 0) {
				boards[x][y] = player;
				setChanged();
				notifyObservers();
				return true;
			} else {
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * Clears the grid of pieces
	 */
	public void clearGrid() {
		for (int i = 0; i < boards.length; i++) {

			for (int j = 0; j < boards.length; j++) {
				boards[i][j] = EMPTY;
			}
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Check if a player has 5 in row
	 * 
	 * @param player the player to check for
	 * @return true if player has 5 in row, false otherwise
	 */
	public boolean isWinner(int player) {
		int otherplayer = ME;
		switch (player) {
		case ME:
			otherplayer = OTHER;
			break;
		case OTHER:
			otherplayer = ME;
			break;
		}
		for (int i = 0; i < boards.length; i++) {
			for (int j = 0; j < boards.length; j++) {
				for (int counter = 0; counter <= INROW; counter++) {
					// Test Rows
					if (boards.length <= counter + j) {
						break;
					}
					if (boards[i][counter + j] == EMPTY || boards[i][counter + j] == otherplayer) {
						break;
					}
					if (counter == INROW - 1) {
						return true;
					}
				}
			}
		}
		for (int i = 0; i < boards.length; i++) {
			for (int j = 0; j < boards.length; j++) {
				for (int counter = 0; counter <= INROW; counter++) {
					// Test Columns
					if (boards.length <= counter + i) {
						break;
					}
					if (boards[counter + i][j] == EMPTY || boards[counter + i][j] == otherplayer) {
						break;
					}
					if (counter == INROW - 1) {
						return true;
					}
				}
			}
		}
		for (int i = 0; i < boards.length; i++) {
			for (int j = 0; j < boards.length; j++) {
				for (int counter = 0; counter <= INROW; counter++) {
					// Test NW Diagonal
					if (boards.length <= counter + i || boards.length <= counter + j) {
						break;
					}
					if (boards[counter + i][counter + j] == EMPTY || boards[counter + i][counter + j] == otherplayer) {
						break;
					}
					if (counter == INROW - 1) {
						return true;

					}
				}
			}
		}
		for (int i = 0; i < boards.length; i++) {
			for (int j = 0; j < boards.length; j++) {
				for (int counter = 0; counter <= INROW; counter++) {
					if(i - counter < 0 || boards.length <= counter + j){
						break;
					}
					if (boards[i - counter][counter + j] == EMPTY || boards[i - counter][counter + j] == otherplayer) {
						break;

					}
					if (counter == INROW - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
