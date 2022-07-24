package com.aziz.redditclone.repository;

import com.aziz.redditclone.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
