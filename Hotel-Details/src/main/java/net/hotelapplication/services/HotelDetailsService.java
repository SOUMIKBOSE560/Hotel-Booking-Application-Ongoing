package net.hotelapplication.services;

import jakarta.ws.rs.NotFoundException;
import net.hotelapplication.entities.HotelDetails;
import net.hotelapplication.repositories.HotelDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class HotelDetailsService {

    @Autowired
    private HotelDetailsRepository hotelDetailsRepository;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private RestTemplate restTemplate;

//    public String saveHotel() {
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            hotelDetailsRepository.save(
//                    HotelDetails.builder()
//                            .hotelName("hotelUsa : " + i)
//                            .availableRoom(random.nextInt(100))
//                            .location("United States")
//                            .rating(restTemplate.getForObject("http://HOTEL-RATING-SERVICE/hotel-rating/getrating/"+"hotelUsa : " + i, Double.class))
//                            .roomCost(Math.round(random.nextDouble(1000)))
//                            .build()
//            );
//        }
//
//        for (int i = 0; i < 10; i++) {
//
//            hotelDetailsRepository.save(
//                    HotelDetails.builder()
//                            .hotelName("hotelMoldova : " + i)
//                            .availableRoom(random.nextInt(100))
//                            .rating(restTemplate.getForObject("http://HOTEL-RATING-SERVICE/hotel-rating/getrating/"+"hotelMoldova : " + i, Double.class))
//                            .location("Moldova")
//                            .roomCost(Math.round(random.nextDouble(1000)))
//                            .build()
//            );
//        }
//
//        for (int i = 0; i < 10; i++) {
//            hotelDetailsRepository.save(
//                    HotelDetails.builder()
//                            .hotelName("hotelIndia : " + i)
//                            .rating(restTemplate.getForObject("http://HOTEL-RATING-SERVICE/hotel-rating/getrating/"+"hotelIndia : " + i, Double.class))
//                            .availableRoom(random.nextInt(100))
//                            .location("India")
//                            .roomCost(Math.round(random.nextDouble(1000)))
//                            .build()
//            );
//        }
//        return "DONE";
//    }

    public String deleteALl() throws IOException {
        hotelDetailsRepository.deleteAll();
        return "ALL DATA DELETED";
    }


    public List<HotelDetails> getHotelByLocation(String location) {
        try {
            return hotelDetailsRepository.getHotelByLocation(location);
        } catch (NotFoundException e) {
            throw new NotFoundException("THIS COUNTRY DOES NOT HAVE ANY AVAILABLE HOTEL");
        }
    }

    public boolean validateTime(Long requestTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(requestTime);
        String requestDay = dateFormat.format(date);
        Date date1 = new Date(System.currentTimeMillis());
        String today = dateFormat.format(date1);

        return requestDay.equals(today);

    }


    public boolean validateUser(String token, String username) throws NoSuchAlgorithmException {
        System.out.println(jwtService.extractUsername(token, username));
        return jwtService.extractUsername(token, username);
    }
}
