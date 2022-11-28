package lab4.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lab4.client.GomokuClient;
import lab4.data.GomokuGameState;

/**
 * The GUI class
 * 
 * @author Leo,Oscar
 */

public class GomokuGUI implements Observer {

	private GomokuClient client;
	private GomokuGameState gamestate;
	private GamePanel gameGridPanel;
	private JFrame frame;
	private JLabel messageLabel;
	private JButton connectButton, newGameButton, disconnectButton;

	/**
	 * The constructor
	 * 
	 * @param g The game state that the GUI will visualize
	 * @param c The client that is responsible for the communication
	 */
	public GomokuGUI(GomokuGameState g, GomokuClient c) {
		this.client = c;
		this.gamestate = g;
		client.addObserver(this);
		gamestate.addObserver(this);

		this.frame = new JFrame("Gomoku");
		JPanel mainPanel = new JPanel();
		this.gameGridPanel = new GamePanel(g.getGameGrid());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(gameGridPanel);
		mainPanel.add(buttonPanel());
		mainPanel.add(messagePanel());
		frame.getContentPane().add(mainPanel);
		frame();
		buttonAction();
		mouse();

		gameGridPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int[] gridPos = gameGridPanel.getGridPosition(e.getX(), e.getY());
				gamestate.move(gridPos[0], gridPos[1]);
			}
		});
	}

	private JPanel buttonPanel() {
		this.connectButton = new JButton("Connect");
		this.newGameButton = new JButton("New game");
		this.disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		newGameButton.setEnabled(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(connectButton);
		buttonPanel.add(newGameButton);
		buttonPanel.add(disconnectButton);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

		return buttonPanel;

	}

	private void frame() {
		frame.pack();
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

	private JPanel messagePanel() {
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
		this.messageLabel = new JLabel();
		messageLabel.setText(gamestate.getMessageString());
		messagePanel.add(messageLabel);
		return messagePanel;
	}

	private void buttonAction() {
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamestate.disconnect();
			}
		});
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamestate.newGame();
			}
		});
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConnectionWindow(client);
			}
		});
	}

	private void mouse() {
		gameGridPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int[] gridPos = gameGridPanel.getGridPosition(e.getX(), e.getY());
				gamestate.move(gridPos[0], gridPos[1]);
			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}
		});
	}

	public void update(Observable arg0, Object arg1) {
		// Update the buttons if the connection status has changed
		if (arg0 == client) {
			if (client.getConnectionStatus() == GomokuClient.UNCONNECTED) {
				connectButton.setEnabled(true);
				newGameButton.setEnabled(false);
				disconnectButton.setEnabled(false);
			} else {
				connectButton.setEnabled(false);
				newGameButton.setEnabled(true);
				disconnectButton.setEnabled(true);
			}
		}

		// Update the status text if the gamestate has changed
		if (arg0 == gamestate) {
			messageLabel.setText(gamestate.getMessageString());
		}

	}

}