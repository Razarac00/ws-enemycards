package com.razarac.enemycards.models;

import java.util.List;

import javax.validation.constraints.*;

import com.razarac.enemycards.models.enums.EnemyElement;

import org.hibernate.validator.constraints.URL;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Enemy {

    @NotNull(message="Enemy id is required")
    private @Setter(AccessLevel.PROTECTED) Long id;

    @NotNull(message="Enemy name is required")
    private String name;
    @NotNull(message="Enemy weaknesses are required")
    private List<EnemyElement> weaknesses;
    @NotNull(message="Enemy resistances are required")
    private List<EnemyElement> resistances;
    
    @URL(protocol = "http")
    private String image;
    
    private String description;

    public Enemy(Long id, String name, List<EnemyElement> weaknesses, List<EnemyElement> resistances, String image, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;

        this.weaknesses = weaknesses;
        this.resistances = resistances;
    }
}