package cs3500.pa01;

import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

/**
 * Object that holds a path and FileTime
 */
public class PathAndTime {
  private final Path path;
  private final FileTime ft;

  /**
   *
   * @param p is the path
   * @param ft is the filetime
   */
  PathAndTime(Path p, FileTime ft) {
    this.path = p;
    this.ft = ft;
  }

  /**
   *
   * @return the path
   */
  public Path getThePath() {
    return this.path;
  }

  /**
   * @return the filetime
   */
  public FileTime getTheFileTime() {
    return this.ft;
  }

}
