package net.hotelapplication.services;

import jakarta.annotation.PostConstruct;
import net.hotelapplication.entities.UserInfo;
import net.hotelapplication.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserInfo create(UserInfo info) throws SQLException {
        try{
           info.setPassword(passwordEncoder.encode(info.getPassword()));
            return userInfoRepository.save(info);
        }
        catch (Exception e){
            throw new SQLException("ERROR SAVING DATA IN DATABASE");
        }
    }

    public UserInfo getUser(String username){
      Optional<UserInfo> userInfo = userInfoRepository.getUserByName(username);
      return userInfo.orElse(null);
    }
}
