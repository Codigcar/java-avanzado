package com.upc.edu.pe.u201621893.controller;

import com.upc.edu.pe.u201621893.dto.ProfileRequest;
import com.upc.edu.pe.u201621893.dto.response.ProfileResponse;
import com.upc.edu.pe.u201621893.model.Profile;
import com.upc.edu.pe.u201621893.service.ProfileService;
import com.upc.edu.pe.u201621893.util.ProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}
