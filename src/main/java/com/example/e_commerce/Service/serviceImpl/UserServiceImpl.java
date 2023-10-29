package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Users;
import com.example.e_commerce.Repo.UserRepo;
import com.example.e_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void saveUser(Users user) {
    userRepository.save(user);
    }

    @Override
    public String updateUser(long id, Users user) {
        Users user1 = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);
        return "User updated successfully";

    }

    @Override
    public Users getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
    }

    @Override
    public Users getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public Users getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
