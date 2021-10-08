package com.upc.edu.pe.u201621893.service;


import com.upc.edu.pe.u201621893.model.VideoGame;

import java.util.List;

public interface VideoGameService extends CrudService<VideoGame, Long> {

    VideoGame registerVideGame(VideoGame videoGame, Long genreId) throws Exception;
    VideoGame updateVideGame(Long id, VideoGame videGame) throws Exception;
    VideoGame desactive(Long id) throws Exception;

    List<VideoGame> findByStatus(Integer status) throws Exception;



}
