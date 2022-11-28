package lab4;

import lab4.client.GomokuClient;
import lab4.data.GomokuGameState;
import lab4.gui.GomokuGUI;
/**
 * The main class
 * @author Leo,Oscar
 */
public class GomokuMain {

	/**
	 * Creates a new Gomoku game 
	 * @param args takes a portnumber
	 */
	public static void main(String[] args) {
		int portnumber;
		
		if (args.length == 0) {
			portnumber = 4000;
		} else {
			portnumber = Integer.parseInt(args[0]);
		}
			
		GomokuClient client = new GomokuClient(portnumber);
		GomokuGameState gameState = new GomokuGameState(client);
		GomokuGUI gui = new GomokuGUI(gameState,client);
	}
}
