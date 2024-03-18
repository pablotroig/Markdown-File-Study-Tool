package cs3500.pa01;


import java.util.Comparator;

/**
 * Object that compares PathAndTime objects based on fileTime
 */
public class CompareByCreationTime implements Comparator<PathAndTime> {
  /**
   * Compares the FileTime of two PathAndTime objects
   *
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return an integer based on what comes first
   */
  @Override
  public int compare(PathAndTime o1, PathAndTime o2) {
    return o1.getTheFileTime().compareTo(o2.getTheFileTime());
  }
}
