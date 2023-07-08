package ua.ithillel.hw22.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandlerTest {

    @Test
    public void Handler_broadCastMessage_zero_messages() {  	
    	Handler handler = new Handler(null, null);
    	Assertions.assertEquals(
    			0, 
    			handler.broadCastMessage(null));
    }
    
    @Test
    public void Handler_run_throw_exeption() {  	
    	Handler handler = new Handler(null, null);
    	Assertions.assertThrows(NullPointerException.class, () -> {
    		handler.run();
        });
    }
    
    @Test
    public void Handler_fileCommandProcessor_incorrect_metadata() {  	
    	Handler handler = new Handler(null, null);
    	Assertions.assertEquals(
    			2, 
    			handler.fileCommandProcessor("a:b"));
    	Assertions.assertEquals(
    			2, 
    			handler.fileCommandProcessor("a:b:0"));
    	Assertions.assertEquals(
    			2, 
    			handler.fileCommandProcessor("a::100"));
    }
    

}
