package com.razarac.enemycards.controllers.clients;

import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.PageModel;

public interface EnemyCardsServiceClient {

    Enemy getEnemy(Long id);

    PageModel getEnemies(Integer pageNumber, Integer pageSize, String search);
    
}
