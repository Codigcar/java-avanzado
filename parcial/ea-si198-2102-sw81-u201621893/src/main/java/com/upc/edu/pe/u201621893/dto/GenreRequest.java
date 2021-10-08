package com.upc.edu.pe.u201621893.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class GenreRequest {


    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    @Size(min=3, message="Descripcion es minimo 3 caracteres")
    private String description;

}
