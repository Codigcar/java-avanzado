package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "state", nullable = false)
    private boolean state;

    // Relacion mucho a muchos (crea tabla UsurioRol entre User y Rol)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
                        ,inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private List<Rol> rolList;

}
