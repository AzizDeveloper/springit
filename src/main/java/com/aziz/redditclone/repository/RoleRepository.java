package com.aziz.redditclone.repository;

import com.aziz.redditclone.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
