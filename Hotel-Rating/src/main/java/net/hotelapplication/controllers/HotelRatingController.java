package net.hotelapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hotel-rating")
public class HotelRatingController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/test")
    public String test(){
        return "HELLO FROM HOTEL RATING SERVICE";
    }

    @GetMapping("/call")
    public String call(){
        String url = "http://HOTEL-DETAILS-SERVICE/hotel-details/test";
        return restTemplate.getForObject(url,String.class);
    }
}
