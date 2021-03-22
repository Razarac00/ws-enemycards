package com.razarac.enemycards.controllers;

import com.razarac.enemycards.controllers.clients.EnemyCardsServiceClient;
import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnemyCardsController {
    @Autowired
    private EnemyCardsServiceClient enemyCardsServiceClient;

    @GetMapping("/enemies")
    public PageModel getEnemies(
                        @RequestParam("pageNumber") Integer pageNumber, 
                        @RequestParam("pageSize") Integer pageSize, 
                        @RequestParam(value = "search", required = false) String search) {
        return enemyCardsServiceClient.getEnemies(pageNumber, pageSize, search);
    }

    @GetMapping("/enemies/{name}")
    public Enemy getEnemy(@PathVariable("name") String name) {
        return enemyCardsServiceClient.getEnemy(name);
    }
}
