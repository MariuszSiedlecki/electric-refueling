package com.security;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
    @Query(value = "SELECT u FROM UserApp u where u.userName=?1")
    Optional<UserApp> findUserAppByName(String username);
}
