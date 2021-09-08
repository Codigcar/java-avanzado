package com.upc.edu.pe.u201621893.service.impl;


import com.upc.edu.pe.u201621893.model.Pet;
import com.upc.edu.pe.u201621893.model.Profile;
import com.upc.edu.pe.u201621893.repository.GenericRepository;
import com.upc.edu.pe.u201621893.repository.PetRepository;
import com.upc.edu.pe.u201621893.repository.ProfileRepository;
import com.upc.edu.pe.u201621893.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl extends CrudServiceImpl<Pet, Long> implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    protected GenericRepository<Pet, Long> getRepository() {
        return petRepository;
    }


    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Pet registerPet(Pet createPetDTORequest, Long profileId) throws Exception {

        Optional<Profile> profileDB = profileRepository.findById(profileId);
        if(!profileDB.isPresent()){
            throw new Exception("profile not found");
        }

        Pet petNew = new Pet();
        Pet petDB;

        try {
            petNew.setName(createPetDTORequest.getName());
            petNew.setAge(createPetDTORequest.getAge());
            petNew.setPhoto(createPetDTORequest.getPhoto());
            petNew.setBreed(createPetDTORequest.getBreed());
            petNew.setSex(createPetDTORequest.getSex());
            petNew.setProfile(profileDB.get());

            petDB = petRepository.save(petNew);
        } catch (Exception ex){
            throw new Exception("Exception Internal Error - Catch");
        }

        //return  modelMapper.map(petDB,PetResponse.class);
        return  petDB;
    }

}
