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
@EqualsAndHashCode(of="id")
@ToString
@Table(value="accounts")
public class Account implements Serializable {
    @Getter
    @PrimaryKey
    private String id= UUID.randomUUID().toString();

    @Getter
    @Setter
    @Column(value="uname")
    private String username;

    @Getter
    @Setter
    @Column(value="email")
    private String email;

    @Getter
    @Setter
    @Column(value="pwd")
    private String passwd;

    @Getter
    @Setter
    @Column(value="createdAt")
    private Date createdAt;

    @Getter
    @Setter
    @Column(value="isActive")
    private Boolean isActive;



}
