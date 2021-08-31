package com.medic.service.impl;

import com.medic.model.Patient;
import com.medic.repository.GenericRepository;
import com.medic.repository.PatientRepository;
import com.medic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends CrudServiceImpl<Patient, Long> implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    protected GenericRepository<Patient, Long> getRepository() {
        return patientRepository;
    }
}
