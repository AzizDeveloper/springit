package com.aziz.redditclone.repository;

import com.aziz.redditclone.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
