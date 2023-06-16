package com.example.twornet.controllers;

import com.example.twornet.models.Comment;
import com.example.twornet.models.User;
import com.example.twornet.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/user/{user}")
    public String createComment(Comment comment, Principal principal, @PathVariable("user") User user, Model model) throws IOException {
        commentService.saveComment(principal, comment, user);
        return "redirect:/user/{user}";
    }
}
