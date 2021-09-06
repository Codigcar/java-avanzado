package com.upc.edu.pe.u201621893.service.impl;


import com.upc.edu.pe.u201621893.model.Profile;
import com.upc.edu.pe.u201621893.repository.GenericRepository;
import com.upc.edu.pe.u201621893.repository.ProfileRepository;
import com.upc.edu.pe.u201621893.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends CrudServiceImpl<Profile, Long> implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    protected GenericRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

}
