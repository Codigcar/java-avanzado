package com.medic.controller;

import com.medic.dto.PatientRequest;
import com.medic.dto.PatientResponse;
import com.medic.exception.ModelNotFoundException;
import com.medic.model.Patient;
import com.medic.service.PatientService;
import com.medic.util.ExceptionMessageEnum;
import com.medic.util.PatientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientConverter patientConverter;

    @GetMapping()
    public ResponseEntity<List<PatientResponse>> getAllPatients()throws Exception{
        List<Patient> patientList = patientService.getAll();
        return new ResponseEntity<>(patientConverter.convertPatientToDto(patientList),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable("id") Long id)throws Exception{
        Patient patient = patientService.getById(id)
                .orElseThrow(()->new ModelNotFoundException(ExceptionMessageEnum.MODEL_NOT_FOUND.getValues()));

        return new ResponseEntity<>(patientConverter.convertPatientToDto(patient), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatient( @Valid @RequestBody PatientRequest patientRequest) throws Exception{
        Patient patientNew = patientService.create(patientConverter.convertPatientToEntity(patientRequest));
        return new ResponseEntity<>(patientNew, HttpStatus.CREATED);
    }

}


//localhost/sustantivo y plural, porque sirve el mismo endpoint para el CRUD
//no colocar localhost/obtenerConsultas , porque solo serviria para el GET y no el CRUD