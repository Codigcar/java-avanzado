
package com.medic.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, message="Nombres es mínimo 3 caracteres")
    @Column(name="firs_name", nullable = false,length = 70)
    private String firstName;

    @NotNull
    @Size(min=3, message="Apellidos es mínimo 8 caracteres")
    @Column(name="last_name", nullable = false,length = 70)
    private String lastName;

    @NotNull
    @Size(min=8, max=8, message="DNI es mínimo 8 caracteres")
    @Column(name="dni", nullable = false,length = 8, unique = true)
    private String dni;

    @NotNull
    @Size(min=3, max=150, message="Direccion es mínimo 3 caracteres")
    @Column(name="address", nullable = false,length = 150)
    private String address;

    @NotNull
    @Size(min=9, max=9, message="Telefono es mínimo 9 caracteres")
    @Column(name="phone", nullable = false,length = 150)
    private String phone;

    @Email(message="Email formato incorrecto")
    @Column(name="email", nullable = true, length = 55)
    private String email;
}

