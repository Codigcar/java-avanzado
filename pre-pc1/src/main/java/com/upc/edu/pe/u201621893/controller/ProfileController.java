package com.upc.edu.pe.u201621893.controller;

import com.upc.edu.pe.u201621893.dto.ProfileRequest;
import com.upc.edu.pe.u201621893.dto.response.ProfileResponse;
import com.upc.edu.pe.u201621893.exception.ModelNotFoundException;
import com.upc.edu.pe.u201621893.model.Profile;
import com.upc.edu.pe.u201621893.service.ProfileService;
import com.upc.edu.pe.u201621893.util.ProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileConverter profileConverter;

    @GetMapping()
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() throws Exception{
        List<Profile> profileList = profileService.getAll();
        return new ResponseEntity<>(profileConverter.convertProfileToDto(profileList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Profile> createProfile( @Valid @RequestBody ProfileRequest profileRequest) throws Exception{
        Profile profileNew = profileService.create(profileConverter.convertProfileToEntity(profileRequest));
        return new ResponseEntity<>(profileNew, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") Long id, @Valid @RequestBody ProfileRequest profileRequest) throws Exception{
        Profile profileUpdated = profileService.updateProfile(id, profileConverter.convertProfileToEntity(profileRequest));
        return new ResponseEntity<Profile>(profileUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Optional<Profile> profile = profileService.getById(id);
        if(profile.isEmpty()) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        profileService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
