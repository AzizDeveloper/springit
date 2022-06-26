package com.aziz.redditclone.repository;

import com.aziz.redditclone.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
