package ua.ithillel.hw22.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientAppTest {

    @Test
    public void ClientApp_main_throw_exeption() {  	
    	Assertions.assertThrows(Exception.class, () -> {
    		ClientApp.main(null);
        });
    }
    
    @Test
    public void ClientApp_messageReceiver_throw_exeption() {  	
    	Assertions.assertThrows(NullPointerException.class, () -> {
    		ClientApp.messageReceiver(null);
        });
    }
    
    @Test
    public void ClientApp_fileCommandProcessor_fileNotFoundMessage() { 	
    	Assertions.assertEquals(
    			1, 
    			ClientApp.fileCommandProcessor(
        				"file: C:\\fake_path", null, null));
    }
}
