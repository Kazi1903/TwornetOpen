package com.example.twornet.services;

import com.example.twornet.models.Comment;
import com.example.twornet.models.User;
import com.example.twornet.repositories.CommentRepository;
import com.example.twornet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public void saveComment(Principal principal, Comment comment, User user) throws IOException {
        comment.setRating(0);
        comment.setNameOfCreated(principal.getName());
        comment.setReview(comment.getReview());
        commentRepository.save(comment);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
    public User getUserByUser(User user) {
        return userRepository.findByEmail(user.getName());
    }

}
