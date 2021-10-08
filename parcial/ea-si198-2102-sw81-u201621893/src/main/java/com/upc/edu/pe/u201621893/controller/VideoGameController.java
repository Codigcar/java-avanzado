package com.upc.edu.pe.u201621893.controller;

import com.upc.edu.pe.u201621893.dto.VideoGameRequest;
import com.upc.edu.pe.u201621893.dto.response.VideoGameResponse;
import com.upc.edu.pe.u201621893.exception.ModelNotFoundException;
import com.upc.edu.pe.u201621893.model.VideoGame;
import com.upc.edu.pe.u201621893.service.VideoGameService;
import com.upc.edu.pe.u201621893.util.VideoGameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres/{genresId}/videoGames")
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private VideoGameConverter videoGameConverter;

    @GetMapping()
    public ResponseEntity<List<VideoGameResponse>> getAll() throws Exception{
        List<VideoGame> videoGameList = videoGameService.getAll();
        return new ResponseEntity<>(videoGameConverter.convertEntityToDto(videoGameList), HttpStatus.OK);
    }

    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<VideoGameResponse>> getAllByStatus(@PathVariable("statusId") Integer statusId) throws Exception{
        List<VideoGame> videoGameList = videoGameService.findByStatus(statusId);
        return new ResponseEntity<>(videoGameConverter.convertEntityToDto(videoGameList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VideoGame> createPet(@Valid @RequestBody VideoGameRequest videoGameRequest, @PathVariable(name = "genresId") Long genresId) throws Exception{
        VideoGame videoGameDB = videoGameService.registerVideGame(videoGameConverter.convertDTOToEntity(videoGameRequest), genresId);
        return new ResponseEntity<>(videoGameDB, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoGame> update(@PathVariable("id") Long id, @Valid @RequestBody VideoGameRequest videoGameRequest) throws Exception{

        VideoGame videoGameUpdated = videoGameService.updateVideGame(id, videoGameConverter.convertDTOToEntity(videoGameRequest));
        return new ResponseEntity<>(videoGameUpdated, HttpStatus.OK);
    }

    @PutMapping("/{id}/desactives")
    public ResponseEntity<VideoGame> desactive(@PathVariable("id") Long id) throws Exception{
        VideoGame videoGameUpdated = videoGameService.desactive(id);
        return new ResponseEntity<VideoGame>(videoGameUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Optional<VideoGame> videoGame = videoGameService.getById(id);
        if(videoGame.isEmpty()) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        videoGameService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
