package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.Comment;
import com.example.e_commerce.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    @PostMapping
    public ResponseEntity<String> addComment(
            @RequestParam Long productId, @RequestParam Long userId, @RequestBody Comment comment) {
        String result = commentService.addComment(productId, userId, comment);
        if (result != null) {
            return ResponseEntity.status(201).body("Comment added with ID: " + result);
        } else {
            return ResponseEntity.badRequest().body("Failed to add comment");
        }
    }

    @PutMapping("/{commentId}")
    public String updateComment(
            @PathVariable Long commentId, @RequestParam String comment) {
        return commentService.updateComment(commentId, comment);

    }

    @GetMapping("/product/{productId}")
    public List<Comment> getCommentsByProductId(@PathVariable Long productId) {
        return commentService.getCommentsByProductId(productId);
    }

    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }
}
