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
	private static final int INROW = 3;
	private int size;
	private int[][] board;

	/**
	 * Constructor
	 * 
	 * @param size The width/height of the game grid
	 */
	public GameGrid(int size) {
		this.size = size;
		this.board = new int[this.size][this.size];
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
		return board[x][y];
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
			if (board[x][y] == 0) {
				board[x][y] = player;
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
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board.length; j++) {
				board[i][j] = EMPTY;
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
		
		  for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	
		            // Skip cells that don't contain the player's piece
		            if (board[i][j] != player) {
		                continue;
		            }

		            // Check all 8 directions around the current cell
		            for (int dx = -1; dx <= 1; dx++) {
		                for (int dy = -1; dy <= 1; dy++) {
		                    if (dx == 0 && dy == 0) continue;  // Skip the center cell, we know that this cell is the player's piece because of if statement above

		                    // Check in the direction (dx, dy)
		                    int count = 1;  // Start with the current cell
		                    for (int k = 1; k < INROW; k++) {
		                        int ni = i + dx * k;  // Calculate new row
		                        int nj = j + dy * k;  // Calculate new column

		                        // Break if out of bounds
		                        if (isOutOfBounds(ni, nj)) {
		                            break; 
		                        }

		                        // Check if the cell matches the player's piece
		                        if (board[ni][nj] == player) {
		                            count++;
		                        } else {
		                            break; 
		                        }
		                    }

		                    // If we found INROW consecutive pieces, return true
		                    if (count == INROW) {
		                        return true;
		                    }
		                }
		            }
		        }
		    }
		  
		return false;
	}
	
	public boolean isOutOfBounds(int x, int y) {
		return x < 0 || x >= board.length || y < 0 || y >= board[x].length;
	}
}
