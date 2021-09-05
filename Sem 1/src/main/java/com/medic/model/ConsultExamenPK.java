package com.medic.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class ConsultExamenPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "consult_id", nullable = false)
    private Consult consult;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}
