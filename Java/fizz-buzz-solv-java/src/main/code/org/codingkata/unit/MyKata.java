package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {
 /**
 * Give an answer to the current game
 *
 * @param number    current number in the game sequence
 * @return          appropriate answer to the current number
 */
public String answer (int number){
    if((number % 3 == 0) && (number %5 == 0)) return "fizzbuzz";
    else if (number % 3 == 0) return "fizz";
    else if (number % 5 == 0) return "buzz";
    else
        return "" + number;
}
}