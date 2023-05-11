package Milestone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Server {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private ObjectMapper mapper;
	private Store store;
	
	public static void main(String[] args) throws IOException{

		// creates server, starts and cleans up
		Server server = new Server();
		server.start(6666);
		server.cleanup();
	}
	
	// starts the server 
	public void start(int port) throws IOException{
		System.out.println("Waiting for a Client connection ......");
		// creates a new server socket
		serverSocket = new ServerSocket(port);
		// accepts a client connection
		clientSocket = serverSocket.accept();
		
		System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
		// creates new PW for sending data to client
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		// creates a new BR for reading data from client
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		// creates a new OM for JSON
		mapper = new ObjectMapper();
		
		String inputLine;
		// loop that reads data from client
		while ((inputLine = in.readLine()) != null) {
			if(".".equals(inputLine)) {
				System.out.println("Got a message to shut the Server down");
				out.println("QUIT");
				break;
			} else {
				System.out.println("Got a message of: " + inputLine);
				out.println("OK");
			}
			}
		System.out.println("Server is shut down");
	}
	
	// closes all open streams and sockets
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	// receives a cart from client as a list
	public List<Product> receiveCartFromClient(){
		List<Product> cart = null;
		// reads list of product objects
		  try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {
			    cart = (List<Product>) ois.readObject();
			  } catch (IOException | ClassNotFoundException e) {
			    e.printStackTrace();
			  }
		  
			  return cart;
			}
	
	// sends an updated cart to the client as a list of products
	public void updateAndSendCartToClient(List<Product> cart) {
		// writes the list of products to the client
		  try (ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {
			    oos.writeObject(cart);
			  } catch (IOException e) {
			    e.printStackTrace();
		 }
	}
	
	// updates the state of the store from a JSON string
	public void StoreState(String jsonString) throws IOException {
		Store store = mapper.readValue(jsonString, Store.class);
		this.store = store;
		System.out.println("Accessing store.....");
		
	}
}
