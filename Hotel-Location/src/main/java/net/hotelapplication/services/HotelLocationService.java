package net.hotelapplication.services;

import com.google.gson.Gson;
import net.hotelapplication.entities.HotelLocation;
import net.hotelapplication.repositories.HotelLocationRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unchecked")
public class HotelLocationService {

    @Autowired
    private HotelLocationRepository hotelLocationRepository;

    public List<HotelLocation> getAllData() {
        return hotelLocationRepository.findAll();
    }

//    public String saveAll() throws IOException {
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url("https://restcountries.com/v3.1/all").build();
//        Response response = client.newCall(request).execute();
//        Gson gson = new Gson();
//        assert response.body() != null;
//        Object o = gson.fromJson(response.body().string(), Object.class);
//        ArrayList<Object> locationObjectList = (ArrayList<Object>) o;
//        for (Object location : locationObjectList) {
//            Map<String, Object> locationMap = (Map<String, Object>) location;
//            Map<String, Object> nameMap = (Map<String, Object>) locationMap.get("name");
//            hotelLocationRepository.save(HotelLocation.builder().commonName((String) nameMap.get("common"))
//                    .officialName((String) nameMap.get("official"))
//                    .region((String) locationMap.get("region"))
//                    .subRegion((String) locationMap.get("subregion"))
//                    .status((String) locationMap.get("status"))
//                    .build());
//        }
//
//        return "DONE";
//    }
}
