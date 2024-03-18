package cs3500.pa01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Object that writes the file
 */
public class MdFileWriter {
  /**
   * writes theFile given an arrayList of string
   *
   * @param fileName is the name of the file
   * @param studyGuide is the list of strings
   */
  public static void writeFile(String fileName, ArrayList<String> studyGuide, ArrayList<Question> questions) {
    String questionBankFileName = "";
    if (fileName.contains(".")) {
      int index = StringUtil.findLastOccurrence(fileName, ".");
      questionBankFileName = fileName.substring(0, index) + ".sr";
    } else {
      throw new IllegalArgumentException("Filename must include .");
    }
    try {
      FileWriter fw = new FileWriter(fileName);
      for (int i = 0; i < studyGuide.size(); i++) {
        if (i == 0) {
          fw.write(studyGuide.get(i));
        } else if (studyGuide.get(i).charAt(0) == '#') {
          fw.write("\n");
          fw.write("\n");
          fw.write(studyGuide.get(i));
        } else {
          fw.write("\n");
          fw.write(studyGuide.get(i));
        }
      }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      FileWriter fw2 = new FileWriter(questionBankFileName);
      for (Question question : questions) {
        fw2.write(question.getQuestion() + "\n");
        fw2.write(question.getAnswer() + "\n");
        fw2.write(question.getType() + "\n");
      }
      fw2.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeUnusedQuestionsToFile(ArrayList<Question> unusedQuestions, String fileName) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (Question question : unusedQuestions) {
        writer.write(question.getQuestion());
        writer.newLine();
        writer.write(question.getAnswer());
        writer.newLine();
        writer.write(question.getType());
        writer.newLine();
      }
    }
  }

  public static void addQuestionsToFile(ArrayList<Question> questions, String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
      for (Question question : questions) {

        writer.write(question.getQuestion());
        writer.newLine();

        writer.write(question.getAnswer());
        writer.newLine();

        writer.write(question.getType());
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}



