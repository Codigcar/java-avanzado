package com.upc.edu.pe.u201621893.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VideoGameRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    @Size(min=3, message="Descripcion es minimo 3 caracteres")
    private String description;

    @NotNull
    private Date releaseDate;

    @NotNull
    private BigDecimal price;

    private Integer status;
}
