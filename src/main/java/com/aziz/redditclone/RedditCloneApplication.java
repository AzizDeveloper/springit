package com.aziz.redditclone;

import com.aziz.redditclone.domain.Comment;
import com.aziz.redditclone.domain.Link;
import com.aziz.redditclone.repository.CommentRepository;
import com.aziz.redditclone.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RedditCloneApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RedditCloneApplication.class, args);
    }

//    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting started with Spring boot2", "https://google.com");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring boot 2 link is awesome!", link);
            commentRepository.save(comment);
            link.addComment(comment);

            Comment comment2 = new Comment("Yeah this course good", link);
            commentRepository.save(comment2);
            link.addComment(comment2);
        };
    }

}
