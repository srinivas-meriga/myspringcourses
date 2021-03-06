package com.rijyos.ms.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    public Optional<User> findByUserEmailId(String userEmailId);

}