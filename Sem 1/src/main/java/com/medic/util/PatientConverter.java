package com.medic.util;

import com.medic.dto.PatientRequest;
import com.medic.dto.PatientResponse;
import com.medic.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Patient convertPatientToEntity(PatientRequest patientRequest){
        return modelMapper.map(patientRequest, Patient.class);
    }

    public PatientResponse convertPatientToDto(Patient patient){
        return modelMapper.map(patient, PatientResponse.class);
    }

    public List<PatientResponse>  convertPatientToDto(List<Patient> patients){
        return patients.stream()
                .map(patient -> convertPatientToDto(patient))
                .collect(Collectors.toList());
    }

}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository