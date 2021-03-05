package com.razarac.enemycards.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.razarac.enemycards.models.enums.EnemyElement;

@Getter @Setter @NoArgsConstructor
public class Enemy {

    private String name;
    private List<EnemyElement> weaknesses;
    private List<EnemyElement> resistances;
    private String image;
    private String description;

    public Enemy(String name, List<EnemyElement> weaknesses, List<EnemyElement> resistances, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
        
        this.weaknesses = weaknesses;
        this.resistances = resistances;
    }
}