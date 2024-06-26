package com.riakhin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(schema = "movie", name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;

    @Column(name = "title")
    private String title;

    @Column(columnDefinition = "text", name = "description")
    @Type(type = "text")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    @Convert(converter = YearConverter.class)
    private Year year;

    @ManyToOne
    @JoinColumn(name = "language_id") //todo поменять тип поля в таблице на SMALLINT
    private Language languageId;

    @ManyToOne
    @JoinColumn(name = "original_language_id") //todo поменять тип поля в таблице на SMALLINT
    private Language originalLanguage;

    @Column(name = "rental_duration")
    private Byte rentalDurationId;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Short length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCoast;

    @Column(columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverterToString.class)
    private Rating rating;

    @Column(columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')",
    name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_actor",
    joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;

    public Set<Features> getSpecialFeatures() {
        if (isNull(specialFeatures) || specialFeatures.isEmpty()) {
            return null;
        }
        Set<Features> result = new HashSet<>();
        String[] split = specialFeatures.split(",");
        for (String sp : split) {
            result.add(Features.getFeaturesByValue(sp));
        }
        result.remove(null);
        return result;
    }

    public void setSpecialFeatures(Set<Features> features) {
        if (isNull(features)) {
            specialFeatures = null;
        } else {
            specialFeatures = features.stream().map(Features::getValue).collect(Collectors.joining(","));
        }
    }
}
