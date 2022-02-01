
package lab2.level;

import java.awt.Color;

public class Room { 
	
	int dx;
	int dy;
	int x;
	int y;
	Color color;
	Room north = null;
	Room south = null;
	Room east = null;
	Room west = null;
	boolean isActive = false;
	
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;
	}

	public void connectNorthTo(Room r) {
		north = r;
	}
	public void connectEastTo(Room r) {
		east = r;
	}
	public void connectSouthTo(Room r) {
		south = r;
	}
	public void connectWestTo(Room r) {
		west = r;
	}
	
	public void printRoom(){
		System.out.println("Room: x = " + x + ", y = " + y + " width = " + dx + ", height = " + dy);
	}
}
