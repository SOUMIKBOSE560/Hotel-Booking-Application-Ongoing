package net.hotelapplication.repositories;

import net.hotelapplication.entities.UserInfo;
import org.hibernate.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    @Query(value = "SELECT * FROM user_table u WHERE u.user_name=:username",nativeQuery = true)
    Optional<UserInfo> getUserByName(String username);
}
