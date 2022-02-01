
package lab2.level;

import java.awt.Rectangle;
import java.util.Observable;

import lab2.Driver;

public class Level extends Observable {

	public Room currentRoom = null;
	boolean locationSet = false;
	int windowX;
	int windowY;

	public boolean place(Room r, int x, int y) {
		if (locationSet == true) {
			System.out.println("Spawn already set");
			return false;
		} else {
			r.x = x;
			r.y = y;
			for (Room room : Driver.rooms) {
				Rectangle Rectangle = new Rectangle(room.x, room.y, room.dx, room.dy);
				System.out.println(Rectangle);
				if (Rectangle.contains(x, y)) {
					System.out.println("Room overlap");
					return false;
				}
			}
			Driver.rooms.add(r);
			System.out.println("Room placed");

			return true;
		}
	}

	public void firstLocation(Room r) {
		this.currentRoom = r;
		currentRoom.isActive = true;
		locationSet = true;
	}
	
	public void newRoom(Room r) {
		currentRoom.isActive = false;
		this.currentRoom = r;
		currentRoom.isActive = true;
		setChanged();
		notifyObservers();
	}

}
