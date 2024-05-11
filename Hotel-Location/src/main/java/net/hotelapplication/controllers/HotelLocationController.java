package net.hotelapplication.controllers;

import net.hotelapplication.entities.HotelLocation;
import net.hotelapplication.services.HotelLocationService;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hotel-location")
public class HotelLocationController {

    @Autowired
    private HotelLocationService hotelLocationService;

//    @GetMapping("/test")
//    public String test(@RequestHeader("Authorization") String authHeader,@RequestParam String username) throws IOException {
//        System.out.println("HEADER : " + authHeader);
//        System.out.println("PARAM : " + username);
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url("https://restcountries.com/v3.1/all").build();
//        Response response = client.newCall(request).execute();
//
//        return response.body().string();
//    }


    @GetMapping("/test")
    public List<HotelLocation> test() throws IOException {
        return hotelLocationService.getAllData();

    }


}
