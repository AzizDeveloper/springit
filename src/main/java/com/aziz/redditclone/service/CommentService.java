package com.aziz.redditclone.service;

import com.aziz.redditclone.domain.Comment;
import com.aziz.redditclone.domain.Link;
import com.aziz.redditclone.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
