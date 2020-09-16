package com.example.scientific.games.demo;


import static com.example.scientific.games.demo.gamelogic.QuickTipLogic.gameOne;
import static com.example.scientific.games.demo.gamelogic.QuickTipLogic.gameThree;
import static com.example.scientific.games.demo.gamelogic.QuickTipLogic.gameTwo;

import com.example.scientific.games.demo.entity.InputDTO;
import com.example.scientific.games.demo.entity.QuickTip;
import com.example.scientific.games.demo.entity.QuickTipWithPanels;
import com.example.scientific.games.demo.entity.marker.Game;
import com.example.scientific.games.demo.exceptions.GameTypeException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class responsible for creating games
 *
 * @author tamas.kiss
 */
public class GameFactory {

    private static final Logger logger = LoggerFactory.getLogger(GameFactory.class);

    /**
     * Method responsible to create the specific game
     *
     * @param gameType The type of the game represents by a number
     * @param numberOfGames How many games should generate
     * @return The created games
     */
    public List<Game> createGames(int gameType, int numberOfGames) {
        logger.info("Start creating games");

        List<Game> games = new ArrayList<>();
        Serializer serializer = new Persister();
        File source = new File("src\\main\\resources\\InputData.xml");
        InputDTO inputDTO = new InputDTO();

        try {
            inputDTO = serializer.read(InputDTO.class, source);
        } catch (Exception e) {
            logger.error("Cannot serialize input data: " + inputDTO.getClass().getSimpleName());
        }

        switch (gameType) {
            case 1:
                for (int i = 0; i < numberOfGames; i++) {
                    QuickTip g1 = QuickTip
                        .builder()
                        .numbers(gameOne(inputDTO.getNumberRangeTo(), inputDTO.getRandomNumbers()))
                        .build();
                    games.add(g1);
                }
                return games;
            case 2:
                for (int i = 0; i < numberOfGames; i++) {
                    QuickTipWithPanels g2 = QuickTipWithPanels
                        .builder()
                        .panels(gameTwo(inputDTO.getPanels(), inputDTO.getRandomNumbers()))
                        .build();
                    games.add(g2);
                }
                return games;
            case 3:
                for (int i = 0; i < numberOfGames; i++) {
                    QuickTipWithPanels g3 = QuickTipWithPanels
                        .builder()
                        .panels(gameThree(inputDTO.getNumberRangeTo(),
                                          inputDTO.getRandomNumbers(),
                                          inputDTO.getPanels()))
                        .build();
                    games.add(g3);
                }
                return games;
        }
        throw new GameTypeException("Right now there are only 1, 2, 3 type of games are available");
    }
}
