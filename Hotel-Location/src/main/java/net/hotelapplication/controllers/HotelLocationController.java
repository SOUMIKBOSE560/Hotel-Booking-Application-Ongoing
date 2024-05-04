package net.hotelapplication.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel-location")
public class HotelLocationController {
    @GetMapping("/test")
    public String test(@RequestHeader("Authorization") String authHeader,@RequestParam String username){
        System.out.println("HEADER : " + authHeader);
        System.out.println("PARAM : " + username);
        return "HELLO FROM LOCATION SERVICE";
    }
}
