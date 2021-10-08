package com.upc.edu.pe.u201621893.controller;

import com.upc.edu.pe.u201621893.dto.PetRequest;
import com.upc.edu.pe.u201621893.dto.ProfileRequest;
import com.upc.edu.pe.u201621893.dto.response.PetResponse;
import com.upc.edu.pe.u201621893.dto.response.ProfileResponse;
import com.upc.edu.pe.u201621893.model.Pet;
import com.upc.edu.pe.u201621893.model.Profile;
import com.upc.edu.pe.u201621893.service.PetService;
import com.upc.edu.pe.u201621893.util.PetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/profiles/{profileId}/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetConverter petConverter;

    @GetMapping()
    public ResponseEntity<List<PetResponse>> getAllPets() throws Exception{
        List<Pet> petList = petService.getAll();
        return new ResponseEntity<>(petConverter.convertEntityToDto(petList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pet> createPet( @Valid @RequestBody PetRequest petRequest, @PathVariable(name = "profileId") Long profileId) throws Exception{
        //Pet petNew = petService.create(petConverter.convertDTOToEntity(petRequest));
        Pet petDB = petService.registerPet(petConverter.convertDTOToEntity(petRequest), profileId);
        //Pet petNew = petConverter.convertEntityToDto(petDB);
        return new ResponseEntity<>(petDB, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable("id") Long id, @Valid @RequestBody PetRequest petRequest) throws Exception{
        Pet petUpdated = petService.updatePet(id, petConverter.convertDTOToEntity(petRequest));
        return new ResponseEntity<Pet>(petUpdated, HttpStatus.OK);
    }


}
