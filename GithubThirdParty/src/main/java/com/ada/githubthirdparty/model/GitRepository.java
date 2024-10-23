package com.ada.githubthirdparty.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "repoEntity")
@Table(name = "git_repo_tbl")
public class GitRepository {

    @Id
    @SequenceGenerator(name = "repoSeq", sequenceName = "repo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repoSeq")
    @Column(name = "repo_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "repo_uuid" ,nullable = false , unique = true)
    private Long repoUUID;

    @Column(name = "repo_name", columnDefinition = "NVARCHAR2(200)")
    private String name;

    @Column(name = "repo_about", columnDefinition = "NVARCHAR2(200)")
    private String about;

//     @Column(name = "repo_owner" , columnDefinition = "NVARCHAR2(50)")
//     private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repo_owner", referencedColumnName = "user_username")
    @JsonBackReference
    private User owner;


//    private List<User> contributors;


    @Column(name = "repo_watch" ,columnDefinition = "NUMBER(4)")
    private int watchingNo;

    @Column(name = "repo_stars",columnDefinition = "NUMBER(4)")
    private int starsNo;

    @Column(name = "repo_fork",columnDefinition = "NUMBER(4)")
    private int forkNo;


//    @ElementCollection(targetClass = Languages.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "languages_tbl")
//    @Column(name = "repo_lang")
//    @Enumerated(EnumType.STRING)
//    private Set<Languages> languages = new HashSet<>();


    @Column(name = "repo_publish")
    private LocalDate publishYear;


    @Column(name = "repo_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean deleted = false;



}
