package com.example.e_commerce.Repo;

import com.example.e_commerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    @Query("select u from Users u where u.username = ?1")
    Users getUserByUsername(String username);
    @Query("select u from Users u where u.email = ?1")
    Users getUserByEmail(String email);
}
