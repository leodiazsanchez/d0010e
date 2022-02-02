package lab2;

import java.awt.Color;
import java.util.ArrayList;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {



	public void run() {
		Room room1 = new Room(200, 200, Color.blue);
		Room room2 = new Room(200, 200, Color.orange);
		Room room3 = new Room(404, 150, Color.blue);

		Level level = new Level();
		level.place(room1, 0, 0);
		level.place(room2, 400, 100);
		level.place(room3, 700, 400);
		room1.connectNorthTo(room2);
		room1.connectWestTo(room3);
		room2.connectNorthTo(room1);
		room3.connectEastTo(room2);
		level.firstLocation(room1);
		
		LevelGUI levelgui = new LevelGUI(level, "Map");
		level.addObserver(levelgui);
	
	}
	

}