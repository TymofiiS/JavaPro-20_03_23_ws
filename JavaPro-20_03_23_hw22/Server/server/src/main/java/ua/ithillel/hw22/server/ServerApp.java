package ua.ithillel.hw22.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;

public class ServerApp {
    
	/**
     * The port that the server listens on.
     */
    private static final int PORT = 9001;

    /**
     * The set of all names of clients in the chat room.  Maintained
     * so that we can check that new clients are not registering name
     * already in use.
     */
    public static HashSet<String> names = new HashSet<String>();

    /**
     * The set of all the print writers for all the clients.  This
     * set is kept so we can easily broadcast messages.
     */
    public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    private static int clientCounter = 0;
    private static String namePrefix = "Client-";
    
    /**
     * The application main method, which just listens on a port and
     * spawns handler threads.
     */
    public static void main(String[] args) throws Exception {
	    System.out.println("The chat server is running.");
	    ServerSocket listener = new ServerSocket(PORT);
	    try {
	        while (true) {
		        new Handler(listener.accept(), 
		        		namePrefix+(clientCounter++))
		        	.start();
	        }
	    } finally {
	        listener.close();
	    }
    }
}
