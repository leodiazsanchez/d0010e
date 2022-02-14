package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {

//		Room room1 = new Room(200, 200, Color.blue);
//		Room room2 = new Room(200, 200, Color.orange);
//		Room room3 = new Room(400, 100, Color.cyan);
//		Room room4 = new Room(400, 300, Color.green);
//		Room room5 = new Room(200, 100, Color.gray);
//
//		switch (2) {
//		case 1:
//			Level level1 = new Level();
//			level1.place(room1, 0, 0);
//			level1.place(room2, 400, 100);
//			level1.place(room3, 700, 400);
//			level1.place(room4, 100, 500);
//			level1.place(room5, 900, 700);
//
//			room1.connectNorthTo(room2);
//			room1.connectSouthTo(room2);
//			room1.connectWestTo(room3);
//
//			room2.connectNorthTo(room1);
//			room2.connectEastTo(room3);
//			room2.connectWestTo(room3);
//
//			room3.connectEastTo(room2);
//			room3.connectWestTo(room2);
//			room3.connectSouthTo(room4);
//
//			room4.connectEastTo(room3);
//			room4.connectNorthTo(room5);
//			room5.connectWestTo(room1);
//
//			level1.firstLocation(room1);
//
//			LevelGUI levelgui = new LevelGUI(level1, "Level1");
//			break;
//
//		case 2:
//			Level level2 = new Level();
//
//			level2.place(room3, 0, 0);
//			level2.place(room1, 400, 100);
//			level2.place(room2, 700, 400);
//
//			room1.connectNorthTo(room2);
//			room1.connectSouthTo(room2);
//			room1.connectWestTo(room3);
//
//			room2.connectNorthTo(room1);
//			room2.connectEastTo(room3);
//			room2.connectWestTo(room3);
//
//			room3.connectEastTo(room2);
//
//			level2.firstLocation(room1);
//
//			LevelGUI levelgui2 = new LevelGUI(level2, "Level2");
//			break;
//
//		default:
//			System.out.println("Choose a level 1 or 2");
//		}

		Room r1 = new Room(200,100,Color.BLUE);
		Room r2 = new Room(100,60,Color.RED);
		Room r3 = new Room(70,30,Color.GREEN);
		Room r4 = new Room(170,60,Color.yellow);
		Room r5 = new Room(100,100,Color.white);
		Room r6 = new Room(40,200,Color.gray);
		Room r7 = new Room(270,160,Color.pink);
		Room r8 = new Room(120,70,Color.magenta);
		Room r9 = new Room(110,120,Color.orange);
		            
		Level testLevel = new Level();
		            
		testLevel.place(r1,50,40);
		testLevel.place(r2,30,25);
		testLevel.place(r3,210,20);
		testLevel.place(r4,230,100);
		testLevel.place(r5,20,80);
		testLevel.place(r6,90,10);
		testLevel.place(r7,20,20);
		testLevel.place(r8,80,50);
		testLevel.place(r9,130,100);

		LevelGUI lvlGUI = new LevelGUI(testLevel, "overlap test");
		

	}

}