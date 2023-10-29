package com.example.e_commerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    @OneToOne(mappedBy = "users",cascade = CascadeType.REMOVE)
    private Cart cart;
    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
    @OneToMany(mappedBy = "user",cascade ={ CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Comment> comments;

}
