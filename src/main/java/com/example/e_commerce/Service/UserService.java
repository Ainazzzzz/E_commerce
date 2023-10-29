package com.example.e_commerce.Service;

import com.example.e_commerce.Model.Users;

public interface UserService {
    void deleteUser(Long userId);
    void saveUser(Users user);
    String updateUser(long id, Users user);
    Users getUserById(Long userId);
    Users getUserByUsername(String username);
    Users getUserByEmail(String email);

}
