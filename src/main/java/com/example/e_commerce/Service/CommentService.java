package com.example.e_commerce.Service;

import com.example.e_commerce.Model.Comment;

import java.util.List;

public interface CommentService {
    void deleteComment(Long commentId);
    String addComment(Long productId, Long userId, Comment comment);
    String updateComment(Long commentId, String comment);
    List<Comment> getCommentsByProductId(Long productId);
    List<Comment> getCommentsByUserId(Long userId);
   Comment getCommentById(Long commentId);

}
