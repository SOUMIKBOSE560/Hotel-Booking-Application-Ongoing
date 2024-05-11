package net.hotelapplication.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Table(name = "Hotel_Rating_Table")
public class HotelRating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Rating_Id")
    public String id;
    @Column(name = "Hotel_Name")
    private String hotelName;
    @Column(name = "Rating_Count")
    private int rating;
}
