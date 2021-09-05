package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "consult_examen")
@IdClass(ConsultExamenPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultExamen {

    @Id
    private Consult consult;
    @Id
    private Exam exam;

}
