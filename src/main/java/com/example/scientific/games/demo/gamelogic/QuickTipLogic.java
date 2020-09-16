package com.example.scientific.games.demo.gamelogic;

import com.example.scientific.games.demo.exceptions.QuickTipNumberException;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * Class responsible for multiple QuickTip game type logic
 *
 * @author tamas.kiss
 */
public class QuickTipLogic {

    /**
     * Game one
     *
     * @param numberRange the range of the random numbers
     * @param randomNumbers how many random numbers should be created
     * @return The created numbers
     */
    public static SortedSet<Integer> gameOne(int numberRange, int randomNumbers) {
        return generateGameNumbers(numberRange, randomNumbers);
    }

    /**
     * Game Two In game two the max number range is always between 1 and 90
     *
     * @param panelsAmount how many game panels should be created
     * @param randomNumbers how many random numbers should be created
     * @return The created game panels
     */
    public static Map<Integer, SortedSet<Integer>> gameTwo(int panelsAmount, int randomNumbers) {
        Map<Integer, SortedSet<Integer>> panels = new TreeMap<>();
        for (int i = 1; i <= panelsAmount; i++) {
            panels.put(i, generateGameNumbers(90, randomNumbers));
        }
        return panels;
    }

    /**
     * Game three
     *
     * @param numberRange the range of the random numbers
     * @param randomNumbers how many random numbers should be created
     * @param panelsAmount how many game panels should be created
     * @return The created game panels
     */
    public static Map<Integer, SortedSet<Integer>> gameThree(int numberRange, int randomNumbers, int panelsAmount) {
        Map<Integer, SortedSet<Integer>> panels = new TreeMap<>();
        for (int i = 1; i <= panelsAmount; i++) {
            panels.put(i, generateGameNumbers(numberRange, randomNumbers));
        }
        return panels;
    }

    /**
     * Method to generate the random unique numbers in order
     *
     * @param numberRange the range of the random numbers
     * @param randomNumbers how many random numbers should be created
     * @return the generated numbers
     */
    private static SortedSet<Integer> generateGameNumbers(int numberRange, int randomNumbers) {
        SortedSet<Integer> orderedUniqueNumbers = new TreeSet<>();
        Random ran = new Random();

        if (numberRange < randomNumbers) {
            throw new QuickTipNumberException("Number range: " + numberRange + " has to be bigger or equal than the"
                                                  + " random numbers: " + randomNumbers);
        }
        while (orderedUniqueNumbers.size() != randomNumbers) {
            orderedUniqueNumbers.add(ran.nextInt(numberRange) + 1);
        }
        return orderedUniqueNumbers;
    }
}
