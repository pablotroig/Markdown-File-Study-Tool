package cs3500.pa01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents an object that reads files that are in the question format
 */
public class QuestionFileReader {
  String fileName;
  QuestionFileReader(String fileName) {
    this.fileName = fileName;
  }

  public int getHard(String fileName) {
    int count = 0;

    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.equalsIgnoreCase("hard")) {
          count++;
        }
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return count;
  }

  public int getEasy(String fileName) {
    int count = 0;
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.equalsIgnoreCase("easy")) {
          count++;
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return count;
  }
}