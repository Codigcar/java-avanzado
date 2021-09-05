package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 70)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "CMP", nullable = false, length = 12, unique = true)
    private String CMP;

    @Column(name = "photo_url", nullable = true)
    private String photoUrl;



}
