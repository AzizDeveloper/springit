package com.aziz.redditclone.service;

import com.aziz.redditclone.domain.Vote;
import com.aziz.redditclone.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
