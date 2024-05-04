package net.hotelapplication.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredential {
    private String username;
    private String password;
}
