package com.upc.edu.pe.u201621893.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class ProfileRequest {


    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String firstName;

    @NotNull
    @Size(min=3, message="Apellido es minimo 3 caracteres")
    private String lastName;

    @NotNull
    @Size(min=8, max = 8, message="Nombre es minimo 8 caracteres")
    private String dni;

    @NotNull
    @Size(min=3, max = 150, message="Direccion es minimo 3 caracteres")
    private String address;

    @NotNull
    @Size(min=9, max = 9, message="Telefono es minimo 9 caracteres")
    private String phone;

    @Email(message="Email formato incorrecto")
    private String email;
}
