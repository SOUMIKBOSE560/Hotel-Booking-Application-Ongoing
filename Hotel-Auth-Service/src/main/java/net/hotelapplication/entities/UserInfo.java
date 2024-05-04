package net.hotelapplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserInfo {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

}
