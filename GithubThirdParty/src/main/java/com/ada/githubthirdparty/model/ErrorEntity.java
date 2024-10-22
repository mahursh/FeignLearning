package com.ada.githubthirdparty.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder

@Entity(name="errorEntity")
@Table(name= "error_tbl")
public class ErrorEntity {

    @Id
    @SequenceGenerator(name = "errorSeq", sequenceName = "error_seq",  allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "errorSeq")
    @Column(name = "error_id" , nullable = false , unique = true)
    private Long id;


    @Column(name = "REQUEST_BODY")
    private String requestBody;

    @Column(name = "RESPONSE_BODY")
    private String responseBody;

    @Column(name = "STATUS_CODE")
    private Integer statusCode;

    @Column(name = "REQUEST_TIME")
    private LocalDateTime requestTime;

    public ErrorEntity(){}
    public ErrorEntity(String requestBody, String responseBody, int statusCode, LocalDateTime requestTime) {

        this.requestBody= requestBody;
        this.responseBody = responseBody;
        this.statusCode = statusCode;
        this.requestTime = requestTime;
    }
}
