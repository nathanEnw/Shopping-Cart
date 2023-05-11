package Milestone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


	public class Client{

		// defines objects and messages
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		private ObjectMapper mapper;
		private Store store;
		
		// initializes store
		public Client() {
			store = new Store();
		}
		
		// starts connection with server
		public void start(String ip, int port) throws UnknownHostException, IOException {
			// new socket
			clientSocket = new Socket(ip, port);
			// initialize PrintWriter
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			// initialize BufferedReader
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// initialize ObjectMapper
			mapper = new ObjectMapper();
		}
		
		// method for sending messages to server and receives response
		public String sendMessage(String message) throws IOException {
			// convert string to JSON
			String jsonString = mapper.writeValueAsString(message);
			// prints message to server
			out.println(jsonString);
			// return response
			return in.readLine();
		}
		
		// method for cleaning up
		public void cleanup() throws IOException {
			// closes PW, BR, OM
			in.close();
			out.close();
			clientSocket.close();
		}
		
		// method for sending the store state to server
		public void StoreState(Store store) throws IOException{
			// convert store object to JSON
			String jsonString = mapper.writeValueAsString(store);
			// send store to server
			out.println(jsonString);
		}
		
		// main method that runs the client
		public static void main(String[] args) throws IOException{
			
			// create new client object
			Client client = new Client();
			// starts connection with server
			client.start("127.0.0.1", 6666);
			
			// define string for holding response from server
			String response;
			// loops 10 times to send message to server
			for(int count = 0; count < 10; ++count) {
				// string to store message
				String message;
				// check if the count is 9
				if (count != 9)
					// if not, prints a message
					message = "Hello from Client " + count;
				else
					// if so, prints a period 
					message = ".";
				// send message to server
				response = client.sendMessage(message);
				
				// print out the server response
				System.out.println("Server response was " + response);
				// check if response is q
				if(response.equals("q"));
				// breaks loop
				break;
				
			}
			
			// cleans up client
			client.cleanup();
		}
		
		// method to send list of products to server
		public void sendCartToServer(List<Product> cart) {
			try {
				// connect to server
				Socket socket = new Socket("127.0.0.1", 6666);
				// create OOS to write list
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				// writes list
				oos.writeObject(cart);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		// method to receive list of products from server
		public List<Product> receiveCartFromServer(){
			// store updated list
			List<Product> updatedCart = null;
			try {
				// connect to server
				Socket socket = new Socket("127.0.0.1", 6666);
				// read the updated list
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				updatedCart = (List<Product>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			// return list of products
			return updatedCart;
		}

	}
