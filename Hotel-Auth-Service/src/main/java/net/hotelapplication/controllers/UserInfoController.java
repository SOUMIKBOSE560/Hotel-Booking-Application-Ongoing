package net.hotelapplication.controllers;

import net.hotelapplication.entities.UserInfo;
import net.hotelapplication.models.APIResponse;
import net.hotelapplication.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public APIResponse<Object> saveUser(@RequestBody UserInfo userInfo) throws SQLException {
        if(userInfoService.create(userInfo) != null){
            return APIResponse.builder()
                    .status(HttpStatus.CREATED)
                    .success(true)
                    .message(userInfo).build();
        }
        return APIResponse.builder().status(HttpStatus.EXPECTATION_FAILED)
                .success(false).message("FAILED TO CREATE USER").build();
    }
}
