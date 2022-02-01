package lab2;

import java.awt.Color;
import java.util.ArrayList;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public static ArrayList<Room> rooms = new ArrayList<>();

	public void run() {
		Room room1 = new Room(200, 200, Color.blue);
		Room room2 = new Room(200, 200, Color.orange);
		Room room3 = new Room(40, 15, Color.blue);

		Level level = new Level();

		level.place(room1, 0, 0);
		level.place(room2, 200, 50);
		room1.connectNorthTo(room2);
		room2.connectNorthTo(room1);
		level.firstLocation(room1);
		
		for (Room room : rooms) {
			room.printRoom();
		}

		LevelGUI levelgui = new LevelGUI(level, "Map");
		level.addObserver(levelgui);
	
	}
	

}