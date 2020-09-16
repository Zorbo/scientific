package com.example.scientific.games.demo.entity;


import com.example.scientific.games.demo.entity.marker.Game;
import java.util.Map;
import java.util.SortedSet;
import lombok.Data;


/**
 * Represents the QuickTip Game
 *
 * @author tamas.kiss
 */
@Data
public class QuickTipWithPanels implements Game {

    /**
     * Represent the game panels
     */
    private Map<Integer, SortedSet<Integer>> panels;

}
