package lab4.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import lab4.data.GameGrid;

/**
 * A panel providing a graphical view of the game board
 * 
 * @author Leo,Oscar
 */

public class GamePanel extends JPanel implements Observer {

	private final int UNIT_SIZE = 15;
	private GameGrid grid;

	/**
	 * The constructor
	 * 
	 * @param grid The grid that is to be displayed
	 */
	public GamePanel(GameGrid grid) {
		this.grid = grid;
		grid.addObserver(this);
		Dimension d = new Dimension(grid.getSize() * UNIT_SIZE + 1, grid.getSize() * (UNIT_SIZE + 1));
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
	}

	/**
	 * Returns a grid position given pixel coordinates of the panel
	 * 
	 * @param x the x coordinates
	 * @param y the y coordinates
	 * @return an integer array containing the [x, y] grid position
	 */
	public int[] getGridPosition(int x, int y) {
		int[] gridPos = new int[2];
		gridPos[0] = x / UNIT_SIZE;
		gridPos[1] = y / UNIT_SIZE;
		return gridPos;

	}

	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	/**
	 * Draws the game grid and the player pieces
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < grid.getSize(); i++) {

			for (int j = 0; j < grid.getSize(); j++) {
				g.setColor(Color.black);
				g.drawRect(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				if (grid.getLocation(i, j) == 1) {
					g.setColor(Color.green);
					g.fillOval(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if (grid.getLocation(i, j) == 2) {
					g.setColor(Color.red);
					g.fillOval(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);

				}
			}
		}
	}
}