package net.hotelapplication.services;

import jakarta.ws.rs.NotFoundException;
import net.hotelapplication.entities.HotelRating;
import net.hotelapplication.repositories.HotelRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HotelRatingService {

    @Autowired
    private HotelRatingRepository hotelRatingRepository;
    public String saveRating() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            hotelRatingRepository.save(
                    HotelRating.builder()
                            .hotelName("hotelUsa : " + i)
                            .rating(random.nextInt(6))
                            .build()
            );
        }

        for (int i = 0; i < 10; i++) {

            hotelRatingRepository.save(
                    HotelRating.builder()
                            .hotelName("hotelMoldova : " + i)
                            .rating(random.nextInt(6))
                            .build()
            );
        }

        for (int i = 0; i < 10; i++) {
            hotelRatingRepository.save(
                    HotelRating.builder()
                            .hotelName("hotelIndia : " + i)
                            .rating(random.nextInt(6))
                            .build()
            );
        }
        return "DONE";
    }

    public double getRatingByHotelName(String name){
        try{
            return hotelRatingRepository.getRatingByName(name).stream().collect(Collectors.averagingDouble(HotelRating::getRating));
        }
        catch (NotFoundException e){
            throw new NotFoundException("DATA NOT FOUND");
        }
    }
}
