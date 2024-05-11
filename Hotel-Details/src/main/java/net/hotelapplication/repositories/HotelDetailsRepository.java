package net.hotelapplication.repositories;

import net.hotelapplication.entities.HotelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelDetailsRepository extends JpaRepository<HotelDetails,String> {

    @Query(value = "SELECT * FROM hotel_details_table hotel WHERE hotel.hotel_location=:location",nativeQuery = true)
    List<HotelDetails> getHotelByLocation(String location);
}
