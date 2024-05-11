package net.hotelapplication.controllers;

import net.hotelapplication.entities.HotelRating;
import net.hotelapplication.services.HotelRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/hotel-rating")
public class HotelRatingController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelRatingService hotelRatingService;
    @GetMapping("/test")
    public String test(){
        return "HELLO FROM HOTEL RATING SERVICE";
    }

    @GetMapping("/call")
    public String call(){
        String url = "http://HOTEL-DETAILS-SERVICE/hotel-details/test";
        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/save")
    public String save(){return hotelRatingService.saveRating();}

    @GetMapping("/getrating/{name}")
    public double getRating(@PathVariable String name){
        return hotelRatingService.getRatingByHotelName(name);
    }

}
