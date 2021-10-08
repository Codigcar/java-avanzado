package com.upc.edu.pe.u201621893.util;

import com.upc.edu.pe.u201621893.dto.VideoGameRequest;
import com.upc.edu.pe.u201621893.dto.response.VideoGameResponse;
import com.upc.edu.pe.u201621893.model.VideoGame;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoGameConverter {

    @Autowired
    private ModelMapper modelMapper;

    public VideoGame convertDTOToEntity(VideoGameRequest petRequest){
        return modelMapper.map(petRequest, VideoGame.class);
    }

    public VideoGameResponse convertEntityToDto(VideoGame pet){
        return modelMapper.map(pet, VideoGameResponse.class);

    }
    public List<VideoGameResponse>  convertEntityToDto(List<VideoGame> pets){
        return pets.stream()
                .map(pet -> convertEntityToDto(pet))
                .collect(Collectors.toList());
    }
}
