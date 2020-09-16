package com.example.scientific.games.demo.entity;


import com.example.scientific.games.demo.entity.marker.Game;
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
public class QuickTip implements Game {

    /**
     * Represent the random numbers
     */
    private final SortedSet<Integer> numbers;

}
