package com.ada.githubthirdparty.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "userEntity")
@Table(name = "user_tbl")
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq",  allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name = "user_id" , nullable = false , unique = true)
    private Long id;

    @Column(name = "user_username", columnDefinition = "NVARCHAR2(50)" , unique = true )
    private  String username;

    @Column(name = "user_name", columnDefinition = "NVARCHAR2(50)" )
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,50}$", message = "Invalid Company Name")
    private String name;

    @Column(name = "user_family", columnDefinition = "NVARCHAR2(50)" )
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,50}$", message = "Invalid Company Name")
    private String family;

    @OneToMany(cascade ={CascadeType.MERGE , CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<GitRepository> repoList;


    @Column(name = "user_deleted")
    private boolean deleted = false;





}