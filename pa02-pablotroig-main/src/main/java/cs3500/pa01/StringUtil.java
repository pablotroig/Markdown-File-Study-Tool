package cs3500.pa01;

import java.util.ArrayList;

/**
 * Object that holds methods that works with Strings
 */
public class StringUtil {

  /**
   * gets and adds to a list the letters between [[]]
   *
   * @param str is the string we are looking through
   * @return an ArrayList that has the extracted phrases
   */
  public static ArrayList<String> bracketExtractor(String str) {
    ArrayList<String> extractedStrings = new ArrayList<>();
    int startIndex = 0;
    while (startIndex < str.length()) {
      int leftBracketIndex = str.indexOf("[[", startIndex);
      int rightBracketIndex = str.indexOf("]]", startIndex);
      if (leftBracketIndex != -1 && rightBracketIndex != -1) {
        extractedStrings.add(str.substring(leftBracketIndex + 2, rightBracketIndex));
        startIndex = rightBracketIndex + 2;
      } else {
        break;
      }
    }
    return extractedStrings;
  }

  /**
   * Keeps track of how many [[ and ]]
   *
   * @param input is the string we are looking through
   * @return an integer of how many two brackets
   */

  public static int countBrackets(String input) {
    int count = 0;
    int index = 0;

    while (index < input.length()) {
      int openingIndex = input.indexOf("[[", index);
      int closingIndex = input.indexOf("]]", index);

      if (openingIndex != -1 && closingIndex != -1) {
        count++;
        if (openingIndex < closingIndex) {
          index = openingIndex + 2;
        } else {
          index = closingIndex + 2;
        }
      } else if (openingIndex != -1) {
        count++;
        index = openingIndex + 2;
      } else if (closingIndex != -1) {
        count++;
        index = closingIndex + 2;
      } else {
        break;
      }
    }

    return count;
  }

  /**
   *
   * @param str is the string we are looking through
   * @param intended is the wanted string
   * @return the index of the last occurrence of a string
   */
  public static int findLastOccurrence(String str, String intended) {
    int lastIndex = -1;
    int index = str.indexOf(intended);
    while (index >= 0) {
      lastIndex = index;
      index = str.indexOf(intended, index + 1);
    }
    return lastIndex;
  }

  public static String getQuestion(String str) {
    String question;
    if (str.contains(":::") && str.contains("[[") && str.contains("]]")) {
      int start = str.indexOf("[[") + 2;
      int end = str.indexOf("]]");
      question = str.substring(start, end);
    } else {
      throw new IllegalArgumentException("String must contain [[:::]]");
    }
    return question;
  }

  public static boolean isQuestion(String str) {
    return str.contains(":::");
  }

  public static ArrayList<String> filterQuestion(ArrayList<String> arr) {
    ArrayList<String> notes = new ArrayList<String>();
    for (int i = 0; i < arr.size(); i ++) {
      String current = arr.get(i);
      if (!current.contains(":::")) {
        notes.add(current);
      }
    }
    return notes;
  }
}


