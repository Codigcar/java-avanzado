package com.upc.edu.pe.u201621893.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false,length = 70)
    private String name;

    @Column(name="age", nullable = false,length = 70)
    private String age;

    @Column(name="breed", nullable = false,length = 80)
    private String breed;

    @Column(name="photo", nullable = true, length = 150)
    private String photo;

    @Column(name="sex", nullable = false,length = 9)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false, foreignKey = @ForeignKey(name = "FK_pet_profile"))
    private Profile profile;
}