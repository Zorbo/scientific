package com.example.scientific.games.demo.entity;


import com.example.scientific.games.demo.entity.marker.Game;
import java.util.SortedSet;
import lombok.Data;


/**
 * Represents the QuickTip Game
 *
 * @author tamas.kiss
 */
@Data
public class QuickTip implements Game {

    /**
     * Represent the random numbers
     */
    private SortedSet<Integer> numbers;

}
