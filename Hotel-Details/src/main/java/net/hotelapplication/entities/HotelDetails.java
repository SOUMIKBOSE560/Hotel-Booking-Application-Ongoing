package net.hotelapplication.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Hotel_Details_Table")
public class HotelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Hotel_id")
    private String id;
    @Column(name = "Hotel_Name")
    private String hotelName;
    @Column(name = "Hotel_Location")
    private String location;
    @Column(name = "Hotel_Available_Room")
    private int availableRoom;
    @Column(name="Hotel_Room_Cost")
    private double roomCost;
    @Column(name = "Hotel_Rating")
    private double rating;

}
