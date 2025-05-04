package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="persona")
public class UserEntity {
    @Id
    private long id;
    private String nom;
    private String cognom1;
    private String cognom2;

    @Column(name="data_naix")
    private Date naixement;
    private String telefon;
    private String email;
}
