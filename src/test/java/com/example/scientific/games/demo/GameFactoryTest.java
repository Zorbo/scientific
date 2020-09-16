package com.example.scientific.games.demo;

import com.example.scientific.games.demo.entity.QuickTip;
import com.example.scientific.games.demo.entity.QuickTipWithPanels;
import com.example.scientific.games.demo.entity.marker.Game;
import com.example.scientific.games.demo.exceptions.GameTypeException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class GameFactoryTest {

    private final GameFactory gameFactory = new GameFactory();

    @Test
    public void createGameOneTypeSuccessful() {

        List<Game> games = gameFactory.createGames(1, 1);
        Assert.assertEquals(1, games.size());
        Assert.assertTrue(games.get(0) instanceof QuickTip);
        Assert.assertEquals(5, ((QuickTip) games.get(0)).getNumbers().size());
    }

    @Test
    public void createGameTwoTypeSuccessful() {

        List<Game> games = gameFactory.createGames(2, 2);
        Assert.assertEquals(2, games.size());
        Assert.assertTrue(games.get(0) instanceof QuickTipWithPanels);
        Assert.assertEquals(3, ((QuickTipWithPanels) games.get(0)).getPanels().size());
        Assert.assertEquals(5, ((QuickTipWithPanels) games.get(0)).getPanels().get(1).size());
    }

    @Test
    public void createGameThreeTypeSuccessful() {

        List<Game> games = gameFactory.createGames(3, 3);
        Assert.assertEquals(3, games.size());
        Assert.assertTrue(games.get(0) instanceof QuickTipWithPanels);
        Assert.assertEquals(3, ((QuickTipWithPanels) games.get(0)).getPanels().size());
        Assert.assertEquals(5, ((QuickTipWithPanels) games.get(0)).getPanels().get(1).size());
    }

    @Test
    public void nonRegisteredGameTypeShouldThrowError() {
        Exception ex = Assert.assertThrows(GameTypeException.class, () -> gameFactory
            .createGames(4, 3));
        String expectedMessage = "Right now there are only 1, 2, 3 type of games are available";
        Assert.assertEquals(expectedMessage, ex.getMessage());
    }
}
