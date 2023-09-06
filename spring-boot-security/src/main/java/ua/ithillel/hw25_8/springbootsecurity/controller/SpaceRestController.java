package ua.ithillel.hw25_8.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceRestController {
	
    @GetMapping("/navigation/destination")
    public String currentDestination(){
        return "Mars";
    }

    @GetMapping("/cantina/menu/today")
    public String menu(){
        return "Microwaved Pizza";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_CAPTAIN')")
    public String getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "User name: " + userDetails.getUsername();
    }
}
