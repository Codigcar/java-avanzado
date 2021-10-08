package com.upc.edu.pe.u201621893.service;


import com.upc.edu.pe.u201621893.model.Profile;

public interface ProfileService extends CrudService<Profile, Long> {
    Profile updateProfile(Long id, Profile profile);
}
