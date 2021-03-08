package com.razarac.enemycards.models;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnemyElement {

    @NotNull(message = "EnemyElement id is required")
    private Long id;
    
    @NotNull(message = "EnemyElement name is required")
    private String name;

    public EnemyElement(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}