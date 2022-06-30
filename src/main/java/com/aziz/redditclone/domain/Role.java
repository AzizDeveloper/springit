package com.aziz.redditclone.domain;

import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

}