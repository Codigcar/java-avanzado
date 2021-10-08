package com.upc.edu.pe.u201621893.dto.response;

import com.upc.edu.pe.u201621893.model.Genre;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class VideoGameResponse {

    private Long id;
    private String name;

    private String description;

    private Date releaseDate;

    private BigDecimal price;

    private Integer status;

    private Genre genre;
}
