package net.hotelapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hotel-details")
public class HotelDetailsController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/test")
    public String test(){
        return "HELLO FROM HOTEL DETAILS CONTROLLER";
    }

    @GetMapping("/callrating")
    public String callRating(){
        String url = "http://HOTEL-RATING-SERVICE/hotel-rating/test";
        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/calllocation")
    public String callLocation(){
        String url = "http://HOTEL-LOCATION-SERVICE/hotel-location/test";
        return restTemplate.getForObject(url,String.class);
    }


}
