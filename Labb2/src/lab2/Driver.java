package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {

		Room room1 = new Room(200, 200, Color.blue);
		Room room2 = new Room(200, 200, Color.orange);
		Room room3 = new Room(400, 100, Color.blue);

		switch (1) {
		case 1:
			Level level1 = new Level();
			level1.place(room1, 0, 0);
			level1.place(room2, 400, 100);
			level1.place(room3, 700, 400);

			room1.connectNorthTo(room2);
			room1.connectSouthTo(room2);
			room1.connectWestTo(room3);

			room2.connectNorthTo(room1);
			room2.connectEastTo(room3);
			room2.connectWestTo(room3);

			room3.connectEastTo(room2);
			room3.connectWestTo(room2);

			level1.firstLocation(room1);

			LevelGUI levelgui = new LevelGUI(level1, "Level1");
			level1.addObserver(levelgui);
			break;

		case 2:
			Level level2 = new Level();

			level2.place(room3, 0, 0);
			level2.place(room1, 400, 100);
			level2.place(room2, 700, 400);

			room1.connectNorthTo(room2);
			room1.connectSouthTo(room2);
			room1.connectWestTo(room3);

			room2.connectNorthTo(room1);
			room2.connectEastTo(room3);
			room2.connectWestTo(room3);

			room3.connectEastTo(room2);

			level2.firstLocation(room1);

			LevelGUI levelgui2 = new LevelGUI(level2, "Level2");
			level2.addObserver(levelgui2);
			break;
		}

	}

}