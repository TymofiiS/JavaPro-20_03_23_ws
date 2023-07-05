package ua.ithillel.hw22.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;


    /**
     * A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for a dealing with a single client
     * and broadcasting its messages.
     */
    public  class Handler extends Thread {
    	
	    private String name;
	    private Socket socket;
	    private BufferedReader in;
	    private PrintWriter out;
	    private LocalDateTime connectionTime;
	
	    
	    public Handler(Socket socket, String name) {
	        this.socket = socket;
	        this.name = name;
	        this.connectionTime = java.time.LocalDateTime.now();
	        this.setDaemon(true);
	    }

	    public void run() {
        try {	

	        in = new BufferedReader(new InputStreamReader(
	                                  socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);
	
	        out.println("[SERVER] Your name will be " + name +".");
	        
	        // add name to name list
	        synchronized (ServerApp.names) {
	            if (!ServerApp.names.contains(name)) {
	            	ServerApp.names.add(name);
	            	System.out.println(name + " added to list");
	            }
            }
	        
	        // add socket's print writer to the set of all writers so
	        // this client can receive broadcast messages.
	        ServerApp.writers.add(out);
	        
	        // Broadcast message about new user
	        broadCastMessage("connected at " + connectionTime);
	
	        // Accept messages from this client and broadcast them.
	        while (true) {
	            String input = in.readLine();
	            
	            if (input == null) {continue;}
	            
	            if("-exit".equals(input)) {break;}
	            
	            broadCastMessage(input);
	        }
        } catch (IOException e) {
        	System.out.println(e);
        } finally {
        	// Client disconnected, remove it from lists
	        if (name != null) {
	        	ServerApp.names.remove(name);
	        	System.out.println(name + " removed from list");
	        	broadCastMessage(name + " disconnected");
	        }
	        if (out != null) {
	        	ServerApp.writers.remove(out);
	        }
	        try {
	            socket.close();
	        } catch (IOException e) {
	        }
        }
    }
    
    private void broadCastMessage(String message) {
        
    	String entireMessage = 
    			"[SERVER] " + name + ": " + message;
    	
    	for (PrintWriter writer : ServerApp.writers) {
        	if(writer == out) {continue;}
        	writer.println(entireMessage);
        }
    	
    	System.out.println(entireMessage);
    }
    
}

