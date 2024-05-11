package net.hotelapplication.repositories;

import net.hotelapplication.entities.HotelLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelLocationRepository extends MongoRepository<HotelLocation,String> {

}
