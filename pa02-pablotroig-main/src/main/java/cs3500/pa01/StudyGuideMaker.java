package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Object that makes the study guide
 */
public class StudyGuideMaker {
  private final ArrayList<Path> paths; //md.getPathList()
  private final int fileNum; //md.getCount()

  /**
   * @param paths   is the path list
   * @param fileNum number of files
   * @param sortBy  is the string to check how to sort
   */
  StudyGuideMaker(ArrayList<Path> paths, int fileNum, String sortBy) {
    this.paths = paths;
    this.fileNum = fileNum;
  }

  /**
   * looks through paths and extracts the correct info
   *
   * @return an arraylist of strings that meet the criteria
   */
  public ArrayList<String> makeStudyGuide() {
    Scanner mdScanner = null;
    ArrayList<String> content = new ArrayList<>();

    for (int i = 0; i < fileNum; i++) {
      try {
        mdScanner = new Scanner(paths.get(i));
      } catch (IOException e) {
        e.printStackTrace();
      }
      while (mdScanner.hasNext()) {
        String nextLine = mdScanner.nextLine();
        if (!nextLine.isEmpty() && nextLine.charAt(0) == '#') {
          content.add(nextLine);
        } else {
          Scanner infoScanner = new Scanner(nextLine);
          if (nextLine.contains("[[") && nextLine.contains("]]")) {
            ArrayList<String> extracted = StringUtil.bracketExtractor(nextLine);
            for (String s : extracted) {
              content.add("- " + s);
            }
          }
          if (StringUtil.countBrackets(nextLine) % 2 != 0) {
            String diffLines =
                nextLine.substring(StringUtil.findLastOccurrence(nextLine, "[[") + 2);
            String str = mdScanner.nextLine();
            if (str.contains("]]")) {
              int index = str.indexOf("]]");
              String secondPart = str.substring(0, index);
              String all = "- " + diffLines + secondPart;
              content.add(all);
            }
          }
        }
      }
    }
    return content;
  }
}
