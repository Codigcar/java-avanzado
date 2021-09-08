package com.upc.edu.pe.u201621893.util;

import com.upc.edu.pe.u201621893.dto.PetRequest;
import com.upc.edu.pe.u201621893.dto.response.PetResponse;
import com.upc.edu.pe.u201621893.model.Pet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Pet convertDTOToEntity(PetRequest petRequest){
        return modelMapper.map(petRequest, Pet.class);
    }

    public PetResponse convertEntityToDto(Pet pet){
        return modelMapper.map(pet, PetResponse.class);

    }
    public List<PetResponse>  convertEntityToDto(List<Pet> pets){
        return pets.stream()
                .map(pet -> convertEntityToDto(pet))
                .collect(Collectors.toList());
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository