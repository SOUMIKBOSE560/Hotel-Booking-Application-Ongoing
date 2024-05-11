package net.hotelapplication.repositories;


import net.hotelapplication.entities.HotelRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRatingRepository extends JpaRepository<HotelRating,String> {
    @Query(value = "SELECT * FROM hotel_rating_table hotel WHERE hotel.hotel_name=:name",nativeQuery = true)
    List<HotelRating> getRatingByName(String name);
}
