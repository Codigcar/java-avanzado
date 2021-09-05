package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medical_consultations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="create_date", nullable = false)
    private String createDate;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false, foreignKey = @ForeignKey(name="FK_consulta_medica"))
    private Patient patient;


}
