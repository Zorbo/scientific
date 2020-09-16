package com.example.scientific.games.demo.entity;


import com.example.scientific.games.demo.entity.marker.Game;
import java.util.Map;
import java.util.SortedSet;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


/**
 * Represents the QuickTip Game
 *
 * @author tamas.kiss
 */
@Getter
@ToString
@Builder
public class QuickTipWithPanels implements Game {

    /**
     * Represent the game panels
     */
    private final Map<Integer, SortedSet<Integer>> panels;

}
