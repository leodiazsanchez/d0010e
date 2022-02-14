
package lab2.level;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
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

		d = new Display(lv, 1920, 1080);

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
			drawRoomConnections(g);
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

		private void drawRoomConnections(Graphics g) {
			for (Room room : lv.rooms) {
				int size = 10;
				if (room.north != null) {
					g.setColor(room.north.color);
					g.fillOval((room.x + room.dx / 2) - size, room.y, size, size);
				}
				if (room.east != null) {
					g.setColor(room.east.color);
					g.fillOval((room.x + room.dx) - size, (room.y + room.dy / 2) - size, size, size);
				}
				if (room.west != null) {
					g.setColor(room.west.color);
					g.fillOval((room.x), (room.y + room.dy / 2) - size, size, size);
				}
				if (room.south != null) {
					g.setColor(room.south.color);
					g.fillOval((room.x + room.dx / 2) - size, room.y + room.dy - size, size, size);
				}

			}
		}

		private class Listener implements KeyListener {

			public void keyPressed(KeyEvent arg0) {
				// Not in use
			}

			public void keyReleased(KeyEvent arg0) {
				// Not in use
			}

			public void keyTyped(KeyEvent event) {
				switch (event.getKeyChar()) {
				case 'w':
					lv.moveNorth();
					break;
				case 'a':
					lv.moveWest();
					break;
				case 's':
					lv.moveSouth();
					break;
				case 'd':
					lv.moveEast();
					break;
				}
			}
		}

	}

}
