
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

    @Column(name="firs_name", nullable = false,length = 70)
    private String firstName;

    @Column(name="last_name", nullable = false,length = 70)
    private String lastName;


    @Column(name="dni", nullable = false,length = 8, unique = true)
    private String dni;

    @Column(name="address", nullable = false,length = 150)
    private String address;

    @Column(name="phone", nullable = false,length = 9)
    private String phone;

    @Column(name="email", nullable = true, length = 55)
    private String email;
}

