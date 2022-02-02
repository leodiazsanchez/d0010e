
package lab2.level;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	private JFrame frame;

	public LevelGUI(Level level, String name) {

		this.lv = level;
		this.frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: You should change 200 to a value
		// depending on the size of the level
		d = new Display(lv, lv.windowX, lv.windowY);

		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0, 0);
		frame.setVisible(true);
		lv.addObserver(this);
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println("Update");
		d.repaint();
	}

	private class Display extends JPanel {

		public Display(Level fp, int x, int y) {

			addKeyListener(new Listener());
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(x, y));
			setFocusable(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawRooms(g);
		}

		private void drawRooms(Graphics g) {
			for (Room room : lv.rooms) {
				g.setColor(room.color);
				g.fillRect(room.x, room.y, room.dx, room.dy);
				if (room == lv.currentRoom) {
					g.setColor(Color.RED);
					g.drawRect(room.x, room.y, room.dx, room.dy);
				}
			}
		}


		private class Listener implements KeyListener {

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyTyped(KeyEvent event) {
				switch (event.getKeyChar()) {
				case 'w':
					if (lv.currentRoom.north != null) {
						lv.newRoom(lv.currentRoom.north);
					}
					break;
				case 'a':
					if (lv.currentRoom.west != null) {
						lv.newRoom(lv.currentRoom.west);
					}
					break;
				case 's':
					if (lv.currentRoom.south != null) {
						lv.newRoom(lv.currentRoom.south);
					}
					break;
				case 'd':
					if (lv.currentRoom.east != null) {
						lv.newRoom(lv.currentRoom.east);
					}
					break;
				}
			}
		}

	}

}
