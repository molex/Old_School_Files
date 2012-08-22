package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {
/**
 * Issue the NASA countdown
 *
 * @param start    number to start with
 * @return         array with numbers from 'start' to 0
 */
public Integer[] countdown (int start){
  Integer[] count = new Integer[start +1];  
  for (int i = start; i>=0; i--){
      count[i] = start -i;
    }
       return count;
    }
}

