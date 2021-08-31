package com.medic.dto;


import lombok.Data;

@Data //Genere el Get y SET
public class PatientResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String dni;

    private String address;

    private String phone;

    private String email;
}
