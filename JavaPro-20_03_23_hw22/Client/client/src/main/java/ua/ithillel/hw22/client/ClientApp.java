package ua.ithillel.hw22.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


//import org.apache.commons.io.IOUtils;

import java.util.Scanner;

public class ClientApp {
    
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 9001)) {
        	
        	BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
        	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        	
            //Here create a thread to receive message from server.
        	Thread thread = new Thread(() -> {
                while (true) {
                    String str;
                    try {
                        str = in.readLine();
                        System.out.println(str);
                    } catch (IOException e) {
                        e.printStackTrace();//error.
                        break;
                    }
                }
            }, "Client Reveiver.");
        	thread.setDaemon(true);
        	thread.start();

            while (true) {

            	String input = scanner.nextLine();
              
                // file: C:\Users\Tsyklop\Desktop\images.jpg
                if (input.startsWith("file:")) {
/*
                    File file = new File(text.replace("file:", "").trim());

                    byte[] buffer = new byte[(int) file.length()];

                    IOUtils.readFully(new FileInputStream(file), buffer);

                    dos.writeUTF("file");
                    dos.writeUTF(file.getName());
                    dos.writeLong(file.length());

                    dos.write(buffer);
                    //dos.flush();

                    //dos.writeUTF("file-end");
*/
                } else {
                	out.println(input);
                }
                
                if ("-exit".equals(input)) {break;}
            }

        }

    }

}
