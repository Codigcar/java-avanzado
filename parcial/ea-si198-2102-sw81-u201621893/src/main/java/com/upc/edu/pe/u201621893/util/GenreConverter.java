package com.upc.edu.pe.u201621893.util;

import com.upc.edu.pe.u201621893.dto.GenreRequest;
import com.upc.edu.pe.u201621893.dto.response.GenreResponse;
import com.upc.edu.pe.u201621893.model.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Genre convertDTOToEntity(GenreRequest profileRequest){
        return modelMapper.map(profileRequest, Genre.class);
    }

    public GenreResponse convertEntityToDto(Genre genre){
        return modelMapper.map(genre, GenreResponse.class);
    }

    public List<GenreResponse>  convertListEntityToDto(List<Genre> profiles){
        return profiles.stream()
                .map(profile -> convertEntityToDto(profile))
                .collect(Collectors.toList());
    }
}

