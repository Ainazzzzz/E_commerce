package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Comment;
import com.example.e_commerce.Model.Product;
import com.example.e_commerce.Model.Users;
import com.example.e_commerce.Repo.CommentRepo;
import com.example.e_commerce.Repo.ProductRepo;
import com.example.e_commerce.Repo.UserRepo;
import com.example.e_commerce.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepository;
    @Autowired
    private ProductRepo productRepository;
    @Autowired
    private UserRepo userRepository;

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public String addComment(Long productId, Long userId, Comment comment) {
     Product product = productRepository.findById(productId).orElseThrow();
        Users user = userRepository.findById(userId).orElseThrow();
        user.getComments().add(comment);
        comment.setUser(user);
        comment.setProduct(product);
        commentRepository.save(comment);
        userRepository.save(user);

   return "Comment added successfully"; }

    @Override
    public String updateComment(Long commentId, String comment) {
       Comment comment1 = commentRepository.findById(commentId).orElseThrow();
         comment1.setCommentText(comment);
            commentRepository.save(comment1);
            return "Comment updated successfully";

    }

    @Override
    public List<Comment> getCommentsByProductId(Long productId) {
       Product product = productRepository.findById(productId).orElseThrow();
         return product.getComments();
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        Users user = userRepository.findById(userId).orElseThrow();
        return user.getComments();
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow();
    }
}
