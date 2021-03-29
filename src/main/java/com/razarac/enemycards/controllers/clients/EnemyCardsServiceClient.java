package com.razarac.enemycards.controllers.clients;

import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.PageModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "enemyCardsCRUD", url = "${enemyCardsCRUD.url}")
public interface EnemyCardsServiceClient {
    
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/enemies/{name}"
    )
    Enemy getEnemy(@PathVariable("name") String name);

    @GetMapping("/enemies")
    PageModel getEnemies(
                @RequestParam(value = "search", required = false) String search,
                @RequestParam("pageNumber") Integer pageNumber, 
                @RequestParam("pageSize") Integer pageSize
                );
    
}
