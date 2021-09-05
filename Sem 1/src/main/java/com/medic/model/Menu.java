package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "icon", length = 20)
    private String icon;

    // Relacion mucho a muchos (crea tabla MenuRol entre Menu y Rol)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private List<Rol> rolList;
}
