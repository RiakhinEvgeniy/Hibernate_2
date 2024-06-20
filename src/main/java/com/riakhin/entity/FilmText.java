package com.riakhin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText {

    @Id
    @Column(name = "film_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Type(type = "text")
    private String description;
}
