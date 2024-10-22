package com.ada.githubthirdparty.model;

import com.ada.githubthirdparty.model.enums.Languages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "repoEntity")
@Table(name = "repo_tbl")
public class GitRepository {

    @Id
    @SequenceGenerator(name = "repoSeq", sequenceName = "repo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repoSeq")
    @Column(name = "repo_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "repo_name", columnDefinition = "NVARCHAR2(50)")
    private String name;

    @Column(name = "repo_about", columnDefinition = "NVARCHAR2")
    private String about;


    private String owner;


//    private List<String> contributors;


    @Column(name = "repo_watch")
    private int watchingNo;

    @Column(name = "repo_stars")
    private int starsNo;

    @Column(name = "repo_fork")
    private int forkNo;


    @ElementCollection(targetClass = Languages.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "languages")
    @Column(name = "repo_lang")
    @Enumerated(EnumType.STRING)
    private Set<Languages> languages = new HashSet<>();


    @Column(name = "repo_publish")
    @Past(message = "Invalid Publish Date")
    private LocalDate publishYear;


    @Column(name = "repo_deleted")
    private boolean deleted = false;



}
