package com.razarac.enemycards.controllers.clients;

import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.PageModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "enemyCardsCRUD", url = "${enemyCardsCRUD.url}")
public interface EnemyCardsServiceClient {
    
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/enemies/{id}"
    )
    Enemy getEnemy(@PathVariable("id") Long id);

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/enemies?pageNumber={pageNumber}&pageSize={pageSize}&search={search}"
    )
    PageModel getEnemies(
                @RequestParam("pageNumber") Integer pageNumber, 
                @RequestParam("pageSize") Integer pageSize, 
                @RequestParam(value = "search", required = false) String search
                );
    
}
