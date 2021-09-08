package com.upc.edu.pe.u201621893.util;

import com.upc.edu.pe.u201621893.dto.ProfileRequest;
import com.upc.edu.pe.u201621893.dto.response.ProfileResponse;
import com.upc.edu.pe.u201621893.model.Profile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Profile convertProfileToEntity(ProfileRequest profileRequest){
        return modelMapper.map(profileRequest, Profile.class);
    }

    public ProfileResponse convertProfileToDto(Profile profile){
        return modelMapper.map(profile, ProfileResponse.class);
    }

    public List<ProfileResponse>  convertProfileToDto(List<Profile> profiles){
        return profiles.stream()
                .map(profile -> convertProfileToDto(profile))
                .collect(Collectors.toList());
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository