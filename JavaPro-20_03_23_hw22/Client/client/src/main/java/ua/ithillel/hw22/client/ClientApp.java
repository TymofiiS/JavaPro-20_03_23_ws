package ua.ithillel.hw22.client;

import java.net.Socket;
import java.io.*;
import org.apache.commons.io.IOUtils;

import java.util.Scanner;

public class ClientApp {
    
    public static void main(String[] args) throws IOException {

    	// Initiate listener for keyboard
        Scanner scanner = new Scanner(System.in);

        // Initiate socket and connect to server
        try (Socket socket = new Socket("localhost", 9001)) {
        	
        	// Initiate In, Out stream buffers
        	BufferedReader in = new BufferedReader(
        			new InputStreamReader(socket.getInputStream()));
        	PrintWriter out = new PrintWriter(
        			socket.getOutputStream(), true);
        	
            // Create a thread to receive and print
            // messages from server.
        	messageReceiver(in);
        
        	// Infinite loop for getting command from user
        	// and send them to the server
            while (true) {
            	
            	// Read input from keyboard
            	String input = scanner.nextLine();
              
            	// Process -file command
                if (input.startsWith("file:")) {             	
                	fileCommandProcessor(
                    		input, out, socket);            	
                    continue;
                }
                
                // Send to server message for broadcasting
            	out.println(input);
            	
                // Process -exit command
                if ("-exit".equals(input)) {break;}
            }
        } 
    }	
    
    public static void messageReceiver(BufferedReader in){   	
        
    	if(in == null) {throw new NullPointerException();}

    	Thread thread = new Thread(() -> {
            while (true) {  
                try {
                    System.out.println(in.readLine());                  
				} catch (IOException e) {
                    e.printStackTrace();                  
                    break;
                } 
            }            
        }, "Message receiver.");
    	thread.setDaemon(true);
    	thread.start();
    }
    
    public static int fileCommandProcessor(
    		String input, 
    		PrintWriter out,
    		Socket socket) {
    	
    	// Check if file exist
        File file = new File(
        		input
        		.replace("file:", "")
				.trim());
        if(!file.exists()) {
        	System.out.println("Please, check the file path.");
        	return 1;
        }
        
        // Initiate buffer and read the file to it
        byte[] buffer = 
        		new byte[(int) file.length()];
        try {
			IOUtils.readFully(
					new FileInputStream(file), buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        // Send to server some metadata
        try {
            out.println(
            		"-file" + ":" +
    				file.getName() + ":" +
    				file.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

        // Send to server buffered file
        try {
			socket.getOutputStream().write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}     
        
        return 0;
    }
}
