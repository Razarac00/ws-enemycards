package com.razarac.enemycards.controllers;

import com.razarac.enemycards.controllers.clients.EnemyCardsServiceClient;
import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/enemies/{id}")
    public Enemy getEnemy(@PathVariable("id") Long id) {
        return enemyCardsServiceClient.getEnemy(id);
    }
}
