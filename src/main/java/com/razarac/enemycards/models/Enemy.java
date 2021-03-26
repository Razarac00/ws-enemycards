package com.razarac.enemycards.models;

import java.util.List;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.URL;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Enemy {

    @NotNull(message = "Enemy id is required")
    private Long id;

    @NotNull(message = "Enemy name is required")
    private String name;
    @NotNull(message = "Enemy weaknesses are required")
    private List<EnemyElement> weaknesses;
    @NotNull(message = "Enemy resistances are required")
    private List<EnemyElement> resistances;
    @NotNull(message = "Enemy immunities are required")
    private List<EnemyElement> immunities;
    
    @URL(protocol = "http")
    private String image;
    
    @NotNull(message = "Enemy description is required")
    private String description;

    public Enemy(Long id, String name, List<EnemyElement> weaknesses, List<EnemyElement> resistances, List<EnemyElement> immunities, String image, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;

        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.immunities = immunities;
    }

    public Enemy() {}
}