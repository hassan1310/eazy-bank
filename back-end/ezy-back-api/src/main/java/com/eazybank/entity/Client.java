package com.eazybank.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Boolean enabled;

}
