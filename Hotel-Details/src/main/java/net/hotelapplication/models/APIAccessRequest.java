package net.hotelapplication.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class APIAccessRequest {
    private UserObject userObject;
    private long requestTime;
}
