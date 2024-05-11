package net.hotelapplication.controllers;

import net.hotelapplication.entities.HotelDetails;
import net.hotelapplication.models.APIAccessRequest;
import net.hotelapplication.services.HotelDetailsService;
import net.hotelapplication.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotel-details")
public class HotelDetailsController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelDetailsService hotelDetailsService;

    @GetMapping("/test")
    public String test() {
        return "HELLO FROM HOTEL DETAILS CONTROLLER";
    }

    @GetMapping("/callrating")
    public String callRating() {
        String url = "http://HOTEL-RATING-SERVICE/hotel-rating/test";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/calllocation")
    public String callLocation() {
        String url = "http://HOTEL-LOCATION-SERVICE/hotel-location/test";
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/getdetails/{location}")
    public List<HotelDetails> getAvailableHotelDetails(@RequestHeader("Authorization") String token, @PathVariable String location, @RequestBody APIAccessRequest apiAccessRequest) throws NoSuchAlgorithmException {
        System.out.println(token);
        System.out.println(location);
        System.out.println(apiAccessRequest);

        if (apiAccessRequest != null && (token != null || !token.isEmpty()) && apiAccessRequest.getRequestTime() != 0
                && apiAccessRequest.getUserObject().getUsername() != null &&
                apiAccessRequest.getUserObject().getPassword() != null) {
            if (hotelDetailsService.validateTime(apiAccessRequest.getRequestTime())
                    && hotelDetailsService.validateUser(token, apiAccessRequest.getUserObject()
                    .getUsername())) {
                return hotelDetailsService.getHotelByLocation(location).stream().map(e -> {
                    e.setRating(
                            restTemplate.getForObject("http://HOTEL-RATING-SERVICE/hotel-rating/getrating/" + e.getHotelName(), Double.class)
                    );
                    return e;
                }).toList();
            }
        }

        List<HotelDetails> hotelDetails = Arrays.asList(HotelDetails.builder().id("NULL").hotelName("NOT FOUND")
                .availableRoom(0).location("NOT FOUND")
                .roomCost(0.0).rating(0.0).build());
        return hotelDetails;
    }

//    @GetMapping("/save")
//    public String saveHotel(){return hotelDetailsService.saveHotel();};

    @DeleteMapping("/deleteall")
    public String deleteAll() throws IOException {
        return hotelDetailsService.deleteALl();
    }

}
