package com.razarac.enemycards.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.razarac.enemycards.controllers.clients.EnemyCardsServiceClient;
import com.razarac.enemycards.models.Enemy;
import com.razarac.enemycards.models.EnemyElement;
import com.razarac.enemycards.models.PageModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EnemyCardsControllerTests {
    
    @TestConfiguration
    static class EnemyCardsControllerTestsConfiguration {

        @Bean
        public EnemyCardsController enemyCardsController() {
            return new EnemyCardsController();
        }

    }

    @Autowired
    EnemyCardsController enemyCardsController;

    @MockBean
    EnemyCardsServiceClient enemyCardsServiceClient;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void getEnemies_ReturnsPageModel_WhenCalled() {
        // Arrange
        PageModel expected = new PageModel();
        Integer pageNumber = 1; 
        Integer pageSize = 4;
        String search = "";

        // Act
        Mockito.when(enemyCardsServiceClient.getEnemies(pageNumber, pageSize, search)).thenReturn(expected);
        PageModel actual = enemyCardsController.getEnemies(pageNumber, pageSize, search);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getEnemy_ReturnsEnemy_WhenCalled() {
        // Arrange
        Long id = 111L;
        String name = "The Lost Sinner";

        List<EnemyElement> weaknesses = List.of(new EnemyElement(1L, "Lightning"), new EnemyElement(2L, "Strike"));
        List<EnemyElement> resistances = List.of(new EnemyElement(3L, "Fire"), new EnemyElement(4L, "Dark"));
        List<EnemyElement> immunities = List.of(new EnemyElement(5L, "None"));

        String image = "https://darksouls.fandom.com/wiki/Lost_Sinner?file=SotFS_LostSinner.jpg";
        String description = "Light the fires unlocked by the Bastille Key to slow her down. NG+ 2 pyromancers will attack mid fight.";

        Enemy expected = new Enemy(id, name, weaknesses, resistances, immunities, image, description);

        // Act
        Mockito.when(enemyCardsServiceClient.getEnemy(name)).thenReturn(expected);
        Enemy actual = enemyCardsController.getEnemy(name);

        // Assert
        assertEquals(expected, actual);
    }
}
