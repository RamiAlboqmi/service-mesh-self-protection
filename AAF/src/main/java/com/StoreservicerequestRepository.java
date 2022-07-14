package com;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreservicerequestRepository extends JpaRepository <Storeservicerequest,Long> {
    List<Storeservicerequest> findByUsername(String username);
    // User findByRequestid(String requestid);
    List <Storeservicerequest> findByRequestid (String requestid);
    List <Storeservicerequest> findByUserip (String requestid);
    List <Storeservicerequest> findByUseripAndDate (String userip, String date);

    Long countByUserip(String userip);

}

