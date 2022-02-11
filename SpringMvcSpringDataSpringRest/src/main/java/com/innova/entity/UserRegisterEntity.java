package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//entity
@Entity
@Table(name="users")
public class UserRegisterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name_surname")
    private String userNameSurname;


    @Column(name = "user_email",nullable = false)
    private String userEmail;

    @Column(name = "user_password",nullable = false)
    private String userPassword;

    @Column(name = "user_age", nullable = false)
    private int userAge;


    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;



}
