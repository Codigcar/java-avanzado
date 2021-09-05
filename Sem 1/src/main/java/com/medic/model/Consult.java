package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consult")
@AllArgsConstructor
@NoArgsConstructor
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_consultorio", length = 3, nullable = true)
    private String numConsultorio;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    //-- Relaciones
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, foreignKey = @ForeignKey(name = "FK_consult_patient"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false, foreignKey = @ForeignKey(name = "FK_consult_specialty"))
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "medic_id", nullable = false, foreignKey = @ForeignKey(name = "FK_consult_medic"))
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "consult_detail_id", nullable = false, foreignKey = @ForeignKey(name = "FK_consultdetail_consult"))
    private ConsultDetail consultDetail;



}
