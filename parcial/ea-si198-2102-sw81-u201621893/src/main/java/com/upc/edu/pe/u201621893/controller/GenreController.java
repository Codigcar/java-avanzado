package com.upc.edu.pe.u201621893.controller;

import com.upc.edu.pe.u201621893.dto.GenreRequest;
import com.upc.edu.pe.u201621893.dto.response.GenreResponse;
import com.upc.edu.pe.u201621893.exception.ModelNotFoundException;
import com.upc.edu.pe.u201621893.model.Genre;
import com.upc.edu.pe.u201621893.service.GenreService;
import com.upc.edu.pe.u201621893.util.GenreConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreConverter genreConverter;

    @GetMapping()
    public ResponseEntity<List<GenreResponse>> getAllProfiles() throws Exception{
        List<Genre> genreList = genreService.getAll();
        return new ResponseEntity<>(genreConverter.convertListEntityToDto(genreList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Genre> create(@Valid @RequestBody GenreRequest genreRequest) throws Exception{
        Genre genreNew = genreService.create(genreConverter.convertDTOToEntity(genreRequest));
        return new ResponseEntity<>(genreNew, HttpStatus.CREATED);
    }


}
