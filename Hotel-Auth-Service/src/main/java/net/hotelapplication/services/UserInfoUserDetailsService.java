package net.hotelapplication.services;

import net.hotelapplication.entities.UserInfo;
import net.hotelapplication.models.CustomUserDetails;
import net.hotelapplication.models.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.getUser(username);
        System.out.println("FETCHED USER : " + userInfo);
        return new CustomUserDetails(UserCredential.builder().username(userInfo.getName()).password(userInfo.getPassword()).build());
    }
}
