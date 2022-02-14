import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {

	static public void readFile(Graph g, String filename) throws IOException{
		try {
		      File file = new File(filename);
		      Scanner reader = new Scanner(file);
		      int numberOfNoders = reader.nextInt();
		      for (int i = 0; i <= numberOfNoders; i++) {
		    	   g.addNode(reader.nextInt(), reader.nextInt(), reader.nextInt());
		      }
		      while (reader.hasNext()) {
		        g.addEdge(reader.nextInt(), reader.nextInt(), reader.nextInt());
		      }
		      reader.close();
		    } catch (IOException e) {
		    	throw new IOException(e.getMessage());
		    } 
	}

}
