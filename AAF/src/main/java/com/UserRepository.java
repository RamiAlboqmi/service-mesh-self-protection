package com;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Long> {
    List<User> findByUsername(String username);
    // User findByRequestid(String requestid);
    List <User> findByRequestid (String requestid);
    List <User> findByUserip (String requestid);
    List <User> findByUseripAndDate (String userip, String date);

    Long countByUserip(String userip);

}

