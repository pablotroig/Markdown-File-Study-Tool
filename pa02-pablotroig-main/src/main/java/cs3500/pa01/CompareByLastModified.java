package cs3500.pa01;

import java.util.Comparator;

/**
 * Object that compares based on modified time
 */

public class CompareByLastModified implements Comparator<Integer> {
  /**
   * Compares two integers
   *
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return an integer representing which integer comes first
   */
  @Override
  public int compare(Integer o1, Integer o2) {
    return o2 - o1;
  }
}
