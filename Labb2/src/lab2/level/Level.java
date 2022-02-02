
package lab2.level;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;


public class Level extends Observable {

	ArrayList<Room> rooms = new ArrayList<>();
	Room currentRoom = null;
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
			Rectangle roomToBePlaced = new Rectangle(r.x, r.y, r.dx, r.dy);
			for (Room room : rooms) {
				Rectangle currentPlacedRoom = new Rectangle(room.x, room.y, room.dx, room.dy);
				if (currentPlacedRoom.intersects(roomToBePlaced)) {
					System.out.println("Room overlap");
					return false;
				}
			}
			rooms.add(r);
			System.out.println("Room placed");

			return true;
		}
	}

	 public void firstLocation(Room r) {
		mapSize();
		currentRoom = r;
		locationSet = true;
	}
	
	void newRoom(Room r) {
		currentRoom = r;
		setChanged();
		notifyObservers();
	}
	
	private void mapSize() {
		double x = 0.0, y = 0.0;
		for (Room room : rooms) {
			Rectangle rectangle = new Rectangle(room.x, room.y, room.dx, room.dy);
			x = rectangle.getMaxX();
			y = rectangle.getMaxY();
		}
		windowX = (int)x;
		windowY = (int)y;
	}

}
