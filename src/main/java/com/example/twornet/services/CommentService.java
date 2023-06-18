package com.example.twornet.services;

import com.example.twornet.models.Comment;
import com.example.twornet.models.InformUser;
import com.example.twornet.models.User;
import com.example.twornet.repositories.CommentRepository;
import com.example.twornet.repositories.InformUserRepository;
import com.example.twornet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final InformUserRepository informUserRepository;

    public void saveComment(Principal principal, Comment comment, User user) throws IOException {
        comment.setRating(0);
        comment.setNameOfCreated(principal.getName());
        comment.setReview(comment.getReview());
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findCommentByUser(user);

        double razmer = comments.size();

        if (razmer > 10) {
            InformUser informUser = informUserRepository.findInformUserByUser(user);
            if(comment.getUmor()==1) {
                double umor = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndUmor(user, 1);
                double razmer1 = comments1.size();
                umor = razmer1 / razmer;
                informUser.setUmor(umor);
                informUserRepository.save(informUser);
            }
            if(comment.getMarshrut()==1) {
                double marshrut = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndMarshrut(user, 1);
                double razmer1 = comments1.size();
                marshrut = razmer1 / razmer;
                informUser.setMarshrut(marshrut);
                informUserRepository.save(informUser);
            }
            if(comment.getPunktualnost()==1) {
                double punkt = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndPunktualnost(user, 1);
                double razmer1 = comments1.size();
                punkt = razmer1 / razmer;
                informUser.setPunktualnost(punkt);
                informUserRepository.save(informUser);
            }
            if(comment.getOpryatnost()==1) {
                double opryatnost = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndOpryatnost(user, 1);
                double razmer1 = comments1.size();
                opryatnost = razmer1 / razmer;
                informUser.setOpryatnost(opryatnost);
                informUserRepository.save(informUser);
            }
            if(comment.getMestnost()==1) {
                double mestnost = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndMestnost(user, 1);
                double razmer1 = comments1.size();
                mestnost = razmer1 / razmer;
                informUser.setMestnost(mestnost);
                informUserRepository.save(informUser);
            }
            if(comment.getBeseda()==1) {
                double beseda = 0;
                List<Comment> comments1 = commentRepository.findCommentByUserAndBeseda(user, 1);
                double razmer1 = comments1.size();
                beseda = razmer1 / razmer;

                informUser.setBeseda(beseda);
                informUserRepository.save(informUser);
            }
        }
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public User getUserByUser(User user) {
        return userRepository.findByEmail(user.getName());
    }

}
