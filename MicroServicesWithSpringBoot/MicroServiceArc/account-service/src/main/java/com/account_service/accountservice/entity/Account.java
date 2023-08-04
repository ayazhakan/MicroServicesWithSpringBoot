package com.account_service.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
@ToString
@Table(value="accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id= UUID.randomUUID().toString();


    @Setter
    @Column(value="uname")
    private String username;


    @Setter
    @Column(value="email")
    private String email;


    @Setter
    @Column(value="pwd")
    private String passwd;


    @Setter
    @Column(value="createdAt")
    private Date createdAt;


    @Setter
    @Column(value="isActive")
    private Boolean isActive;



}
