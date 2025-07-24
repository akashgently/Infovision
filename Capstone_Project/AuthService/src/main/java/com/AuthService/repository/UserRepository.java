package com.AuthService.repository;

import com.AuthService.entity.UserDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserDE,Long> {
    @Query(value = "SELECT users from UserDE users where users.emailId =?1 or users.mobile = ?2 ")
    public UserDE findUserByEmailAndPhoneNumber(String emailId, String phoneNumber);

    @Query("SELECT u FROM UserDE u WHERE u.emailId = ?1")
    public UserDE findByEmail(String email);

    @Query(value = "select * from users where user_type != '1' AND user_type != '0' ",nativeQuery = true)
    List<UserDE> findAllDetails();
}

