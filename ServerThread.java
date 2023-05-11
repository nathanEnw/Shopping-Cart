package Milestone;
import java.io.IOException;

public class ServerThread extends Thread{
	
	public void run() {
		// create server
		Server server = new Server();
		try {
			// starts server and cleans up
			server.start(6666);
			server.cleanup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
