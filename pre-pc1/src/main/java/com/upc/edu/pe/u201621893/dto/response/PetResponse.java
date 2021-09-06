package com.upc.edu.pe.u201621893.dto.response;

import com.sun.istack.NotNull;
import com.upc.edu.pe.u201621893.model.Profile;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class PetResponse {

    private Long id;
    private String name;

    private String age;

    private String breed;

    private String photo;

    private String sex;

    private Profile profile;
}
