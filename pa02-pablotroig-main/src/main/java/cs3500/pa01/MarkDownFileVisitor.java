package cs3500.pa01;


import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;


/**
 * Object that can walk through a filepath
 */
public class MarkDownFileVisitor implements FileVisitor<Path> {

  private int count = -1;
  private final ArrayList<Path> pathList = new ArrayList<>();
  private final ArrayList<String> fileNames = new ArrayList<>();
  private final ArrayList<Integer> modified = new ArrayList<>();
  private final ArrayList<PathAndTime> pathAndTimes = new ArrayList<>();


  /**
   * Gets a path list when walked and sorts is based on a string parameter
   *
   * @param sortBy is the way we want to sort
   *
   * @return a list of paths
   */
  public ArrayList<Path> getPathList(String sortBy) {
    ArrayList<Path> paths = new ArrayList<>();
    switch (sortBy) {
      case "fileName" -> {
        fileNames.sort(new CompareByFileName());
        for (String fileName : fileNames) {
          for (Path path : pathList) {
            if (path.getFileName().toString().equals(fileName)) {
              paths.add(path);
            }
          }
        }
      }
      case "modified" -> {
        modified.sort(new CompareByLastModified());
        for (Integer integer : modified) {
          for (Path path : pathList) {
            if ((int) (path.toFile().lastModified()) == integer) {
              paths.add(path);
            }
          }
        }
      }
      case "created" -> {
        pathAndTimes.sort(new CompareByCreationTime());
        for (PathAndTime pathAndTime : pathAndTimes) {
          paths.add(pathAndTime.getThePath());
        }
      }
    }
    return paths;
  }

  /**
   *
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return CONTINUE
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    return CONTINUE;
  }

  /**
   * gets the filename, path, and creates a PathAndTime Object
   *
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   *
   * @return CONTINUE
   */

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    if (count == -1) {
      count = 0;
    }
    if (attrs.isRegularFile() && file.getFileName().toString().endsWith(".md")) {
      fileNames.add(file.getFileName().toString());
      pathList.add(file.toAbsolutePath());
      modified.add((int) file.toFile().lastModified());
      PathAndTime pat = new PathAndTime(file.toAbsolutePath(), attrs.creationTime());
      pathAndTimes.add(pat);
      count++;
    }
    return CONTINUE;
  }

  /**
   *
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return CONTINUE
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    return CONTINUE;
  }

  /**
   *
   * @param dir
   *          a reference to the directory
   * @param exc
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return CONTINUE
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
    return CONTINUE;
  }

  /**
   * gets the amount of md files
   *
   * @return count of md files
   */
  public int getCount() {
    if (count == -1) {
      throw new IllegalStateException("Called before any of the FileVisitor callback methods");
    }
    return count;
  }
}