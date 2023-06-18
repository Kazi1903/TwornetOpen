package com.example.twornet.repositories;

import com.example.twornet.models.Comment;
import com.example.twornet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //ArrayList<Comment> findCommentByUser(User user);
    List<Comment> findCommentByUser(User user);

    List<Comment> findCommentByUserAndUmor(User user, int integ);

    List<Comment> findCommentByUserAndMarshrut(User user, int integ);

    List<Comment> findCommentByUserAndPunktualnost(User user, int integ);

    List<Comment> findCommentByUserAndOpryatnost(User user, int integ);

    List<Comment> findCommentByUserAndMestnost(User user, int integ);

    List<Comment> findCommentByUserAndBeseda(User user, int integ);

  //  List<Comment> findCommentByUserAndUmorAndMarshrutAndPunktualnostAndOpryatnostAndMestnostAndBeseda(User user, int integ);
}
