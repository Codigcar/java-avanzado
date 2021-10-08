package com.upc.edu.pe.u201621893.service.impl;


import com.upc.edu.pe.u201621893.model.Genre;
import com.upc.edu.pe.u201621893.repository.GenericRepository;
import com.upc.edu.pe.u201621893.repository.GenreRepository;
import com.upc.edu.pe.u201621893.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends CrudServiceImpl<Genre, Long> implements GenreService {

    @Autowired
    private GenreRepository profileRepository;

    @Override
    protected GenericRepository<Genre, Long> getRepository() {
        return profileRepository;
    }

}
