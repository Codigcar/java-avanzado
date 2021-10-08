package com.upc.edu.pe.u201621893.repository;


import com.upc.edu.pe.u201621893.model.VideoGame;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoGameRepository extends GenericRepository<VideoGame,Long> {

    List<VideoGame> findVideoGameByStatus(Integer status);
}
