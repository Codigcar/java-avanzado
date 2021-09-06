package com.medic.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data //Genere el Get y SET
public class PatientRequest {

    @NotNull
//    @Size(min=3, message="Nombres es mínimo 3 caracteres")
    @Size(min=3, message="{nombres.size}")
    private String firstName;

    @NotNull
//    @Size(min=3, message="Apellidos es mínimo 8 caracteres")
    @Size(min=3, message="{apellidos.size}")
    private String lastName;

    @NotNull
    @Size(min=8, max=8, message="DNI es mínimo 8 caracteres")
    private String dni;

    @NotNull
    @Size(min=3, max=150, message="Direccion es mínimo 3 caracteres")
    private String address;

    @NotNull
    @Size(min=9, max=9, message="Telefono es mínimo 9 caracteres")
    private String phone;

    @Email(message="Email formato incorrecto")
    private String email;
}
