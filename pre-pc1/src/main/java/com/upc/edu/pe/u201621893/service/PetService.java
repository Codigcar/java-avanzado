package com.upc.edu.pe.u201621893.service;

import com.upc.edu.pe.u201621893.model.Pet;
import com.upc.edu.pe.u201621893.model.Profile;

public interface PetService extends CrudService<Pet, Long> {

    Pet registerPet(Pet createPetDTORequest, Long profileId) throws Exception;
    Pet updatePet(Long id, Pet pet);


}
