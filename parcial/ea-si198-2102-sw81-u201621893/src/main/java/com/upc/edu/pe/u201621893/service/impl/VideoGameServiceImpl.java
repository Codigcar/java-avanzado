package com.upc.edu.pe.u201621893.service.impl;


import com.upc.edu.pe.u201621893.exception.ExceptionResponse;
import com.upc.edu.pe.u201621893.exception.ModelNotFoundException;
import com.upc.edu.pe.u201621893.model.Genre;
import com.upc.edu.pe.u201621893.model.VideoGame;
import com.upc.edu.pe.u201621893.repository.GenericRepository;
import com.upc.edu.pe.u201621893.repository.VideoGameRepository;
import com.upc.edu.pe.u201621893.repository.GenreRepository;
import com.upc.edu.pe.u201621893.service.VideoGameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameServiceImpl extends CrudServiceImpl<com.upc.edu.pe.u201621893.model.VideoGame, Long> implements VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    protected GenericRepository<VideoGame, Long> getRepository() {
        return videoGameRepository;
    }


    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public VideoGame registerVideGame(VideoGame videoGame, Long genreId) throws Exception {

        Optional<Genre> genreDBOptional = genreRepository.findById(genreId);
        if(genreDBOptional.isEmpty()){
            throw new Exception("genre not found");
        }

        try {
            videoGame.setGenre(genreDBOptional.get());
            videoGame.setStatus(1);
            return videoGameRepository.save(videoGame);
        } catch (Exception ex){
            throw new Exception("Exception Internal Error - Catch");
        }
    }

    @Override
    public VideoGame updateVideGame(Long id, VideoGame videGame)  throws Exception {

        Optional<VideoGame> videoGameDB = videoGameRepository.findById(id);
        if(videoGameDB.isEmpty()){
            throw new Exception("videoGame not found");
        }

        videoGameDB.get().setStatus (videGame.getStatus());
        videoGameDB.get().setName(videGame.getName());
        videoGameDB.get().setDescription(videGame.getDescription());
        videoGameDB.get().setPrice(videGame.getPrice());
        videoGameDB.get().setReleaseDate(videGame.getReleaseDate());

        return videoGameRepository.save(videoGameDB.get());
    }

    @Override
    public VideoGame desactive(Long id) throws Exception {
        Optional<VideoGame> videoGameDB = videoGameRepository.findById(id);
        if(videoGameDB.isEmpty()){
            throw new Exception("videoGame not found");
        }
        videoGameDB.get().setStatus(0);
        return videoGameRepository.save(videoGameDB.get());
    }

    @Override
    public List<VideoGame> findByStatus(Integer status) throws Exception {
        return videoGameRepository.findVideoGameByStatus(status);
    }
}
