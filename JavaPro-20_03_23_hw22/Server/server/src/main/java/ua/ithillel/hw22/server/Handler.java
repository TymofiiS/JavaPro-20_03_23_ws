package ua.ithillel.hw22.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import org.apache.commons.io.IOUtils;

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
        	
        	// Initiate In, Out stream buffers
	        in = new BufferedReader(new InputStreamReader(
	                                  socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);
	
	        out.println("[SERVER] Your name will be " + name +".");
	        
	        // Add name to name list
	        synchronized (ServerApp.names) {
	            if (!ServerApp.names.contains(name)) {
	            	ServerApp.names.add(name);
	            	System.out.println(name + " added to list");
	            }
            }
	        
	        // Add socket's print writer to the set of all writers so
	        // this client can receive broadcast messages.
	        ServerApp.writers.add(out);
	        
	        // Broadcast message about new user
	        broadCastMessage("connected at " + connectionTime);
	
	        // Receive messages from this client and broadcast them.
	        while (true) {
	        	
	        	// Read any message from particular user
	            String input = in.readLine().trim();	            
	            if (input == null) {continue;}
	            
	            // Process command for disconnected by user
	            if("-exit".equals(input)) {break;}
	            
	            // Process command for file transferring
                if (input.startsWith("-file:")) {

                	// Parse -file command to file name and size
                	List<String> items = 
                			Arrays.asList(input.split(":"));
                	if(items.size() != 3) {continue;}
                	
                    String fileName = items.get(1).trim();
                    if(fileName.length() == 0) {continue;}
                    
                    int fileLength = 
                    		Integer.valueOf(items.get(2).trim());
                    if(fileLength == 0) {continue;}
                    
                    // Initiate buffer for reading file from stream
                    byte[] buffer = new byte[fileLength];
                    
                    // Read stream to buffer
                    socket.getInputStream().read(
                    		buffer, 0, fileLength);

                    // Ensure storage path existing
                    Path path = Paths.get(
                    		System.getProperty("user.dir"), 
                    		ServerApp.storageName);
                    File file = path.toFile();
                    if (!file.exists()) {file.mkdirs();}
                    
                    // Write buffer into file on drive
                    IOUtils.write(buffer, 
                    		new FileOutputStream(
                    				file.getAbsolutePath() + "\\" + fileName));
                    
                    // Write some log
                    System.out.println(
                    		"File: " + fileName + " saved to storage.");
                    
                    // Send confirmation to user
                    out.println("[SERVER] File transfer OK");
                    
                    continue;
                }
                
                // Send any chat message to all participants
            	broadCastMessage(input);			
	        }
        } catch (IOException e) {
        	System.out.println(e);
        } finally {
        	
        	// Client disconnected, remove it from lists	        
        	if (name != null) {
	        	ServerApp.names.remove(name);
	        	
	        	// Write some log
	        	System.out.println(name + " removed from list");
	        	
	        	// Inform all participants
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

