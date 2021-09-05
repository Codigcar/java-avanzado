package com.medic.service.impl;

import com.medic.model.Consult;
import com.medic.repository.ConsultRepository;
import com.medic.repository.GenericRepository;
import com.medic.repository.PatientRepository;
import com.medic.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultServiceImpl extends CrudServiceImpl<Consult, Long> implements ConsultService {

    @Autowired
    private ConsultRepository consultReposit;

    @Override
    protected GenericRepository<Consult, Long> getRepository() {
        return consultReposit;
    }
}
