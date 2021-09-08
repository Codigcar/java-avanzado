package com.upc.edu.pe.u201621893.dto;

import com.sun.istack.NotNull;
import com.upc.edu.pe.u201621893.model.Profile;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class PetRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    private String age;

    @NotNull
    @Size(min=3, message="Breed es minimo 3 caracteres")
    private String breed;

    @NotNull
    private String photo;

    @NotNull
    private String sex;

    @NotNull
    private Profile profile;
}
