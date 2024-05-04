package net.hotelapplication.models;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class APIResponse<T> {
    private HttpStatus status;
    private boolean success;
    private T message;
}
