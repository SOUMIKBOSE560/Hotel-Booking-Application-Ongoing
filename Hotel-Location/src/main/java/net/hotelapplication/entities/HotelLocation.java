package net.hotelapplication.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Document(collection = "hotel-location")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class HotelLocation {
    @Id
    private String id;
    private String commonName;
    private String officialName;
    private String region;
    private String subRegion;
    private String status;
}
