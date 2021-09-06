package com.upc.edu.pe.u201621893.dto.response;


import lombok.Data;

@Data
public class ProfileResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String dni;

    private String address;

    private String phone;

    private String email;
}
