package com.medic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consult_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultDetail {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "diagnostic", nullable = false, length = 150)
    private String diagnostic;

    @Column(name = "treatment", nullable = false, length = 500)
    private String treatment;

    // -- Relaciones

    @OneToMany(mappedBy = "consultDetail")
    private List<Consult> consults;
}
