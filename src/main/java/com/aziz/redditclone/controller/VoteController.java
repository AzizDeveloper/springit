package com.aziz.redditclone.controller;

import com.aziz.redditclone.domain.Link;
import com.aziz.redditclone.domain.Vote;
import com.aziz.redditclone.repository.LinkRepository;
import com.aziz.redditclone.repository.VoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VoteController {

    private VoteRepository voteRepository;
    private LinkRepository linkRepository;

    public VoteController(VoteRepository voteRepository, LinkRepository linkRepository) {
        this.voteRepository = voteRepository;
        this.linkRepository = linkRepository;
    }

    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkID, @PathVariable short direction, @PathVariable int voteCount) {
        Optional<Link> optionalLink = linkRepository.findById(linkID);
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteRepository.save(vote);

            int updatedVoteCount = voteCount + direction;
            link.setVoteCount(updatedVoteCount);
            linkRepository.save(link);
            return updatedVoteCount;
        }
        return voteCount;
    }
}