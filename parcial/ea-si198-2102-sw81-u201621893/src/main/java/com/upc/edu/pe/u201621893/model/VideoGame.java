package com.upc.edu.pe.u201621893.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="video_game")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false,length = 70)
    private String name;

    @Column(name="description", nullable = false,length = 170)
    private String description;

    @Column(name="release_date", nullable = false)
    private Date releaseDate;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name="status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "genre_id",nullable = false, foreignKey = @ForeignKey(name = "FK_videogame_genre"))
    private Genre genre;


}