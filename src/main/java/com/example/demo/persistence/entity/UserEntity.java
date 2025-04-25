package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Column(name="last_name")
    private String lastName;
    private String email;
    private byte age;
}
