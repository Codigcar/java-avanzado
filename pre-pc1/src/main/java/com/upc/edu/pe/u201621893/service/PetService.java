package com.upc.edu.pe.u201621893.service;

import com.upc.edu.pe.u201621893.dto.PetRequest;
import com.upc.edu.pe.u201621893.dto.response.PetResponse;
import com.upc.edu.pe.u201621893.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

    PetResponse registerProduct(PetRequest createPetDTORequest, Long profileId) throws Exception;


}
