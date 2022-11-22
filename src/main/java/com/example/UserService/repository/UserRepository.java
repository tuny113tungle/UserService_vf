package com.example.UserService.repository;

import com.example.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where username= :username and password= :password", nativeQuery = true)
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
