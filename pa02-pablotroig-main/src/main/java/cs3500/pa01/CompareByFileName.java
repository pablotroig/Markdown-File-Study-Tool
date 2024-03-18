package cs3500.pa01;

import java.util.Comparator;

/**
 * Object that compares filenames
 */
public class CompareByFileName implements Comparator<String> {
  /**
   * compares strings
   *
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return an integer based on which comes first
   */
  @Override
  public int compare(String o1, String o2) {
    return o1.compareTo(o2);
  }
}

