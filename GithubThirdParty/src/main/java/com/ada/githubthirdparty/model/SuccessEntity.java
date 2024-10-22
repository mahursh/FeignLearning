package com.ada.githubthirdparty.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;



@Getter
@Setter
@SuperBuilder

@Entity(name = "successEntity")
@Table(name = "success_tbl")
public class SuccessEntity {

    @Id
    @SequenceGenerator(name = "successSeq" , sequenceName = "success_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "successSeq")
    @Column(name = "suc_id" , nullable = false , unique = true)
    private Long id;

    @Column(name = "REQUEST_BODY")
    private String requestBody;

    @Column(name = "RESPONSE_BODY")
    private String responseBody;

    @Column(name = "STATUS_CODE")
    private Integer statusCode;

    @Column(name = "REQUEST_TIME")
    private LocalDateTime requestTime;

    public SuccessEntity(){}
    public SuccessEntity(String requestBody, String responseBody, int statusCode, LocalDateTime requestTime) {
        this.requestBody= requestBody;
        this.responseBody = responseBody;
        this.statusCode = statusCode;
        this.requestTime = requestTime;

    }
}
