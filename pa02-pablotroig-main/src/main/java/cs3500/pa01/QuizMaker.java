package cs3500.pa01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class QuizMaker {
  private final String fileName;

  QuizMaker(String fileName) {
    this.fileName = fileName;
  }

  /**
   * gets the hard questions
   *
   * @return the hard questions
   * @throws IOException
   */
  public ArrayList<Question> getHardQuestions() throws IOException {
    ArrayList<Question> hardQuestions = new ArrayList<Question>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    String currentQuestion = null;
    String currentAnswer = null;
    String difficulty = null;

    while ((line = reader.readLine()) != null) {
      if (currentQuestion == null) {
        currentQuestion = line;
      } else if (currentAnswer == null) {
        currentAnswer = line;
      } else {
        difficulty = line.toLowerCase();

        if (difficulty.equals("hard")) {
          Question question = new HardQuestion(currentQuestion, currentAnswer);
          hardQuestions.add(question);
        }

        currentQuestion = null;
        currentAnswer = null;
        difficulty = null;
      }
    }
    return hardQuestions;
  }

  /**
   * gets the easy questions
   *
   * @return the easy questions
   * @throws IOException
   */
  public ArrayList<Question> getEasyQuestions() throws IOException {
    ArrayList<Question> easyQuestions = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    String currentQuestion = null;
    String currentAnswer = null;
    String difficulty = null;

    while ((line = reader.readLine()) != null) {
      if (currentQuestion == null) {
        currentQuestion = line;
      } else if (currentAnswer == null) {
        currentAnswer = line;
      } else {
        difficulty = line.toLowerCase();

        if (difficulty.equals("easy")) {
          Question question = new EasyQuestion(currentQuestion, currentAnswer);
          easyQuestions.add(question);
        }

        currentQuestion = null;
        currentAnswer = null;
        difficulty = null;
      }
    }
    return easyQuestions;
  }

  /**
   * gets the questions to show the user
   *
   * @param size
   * @param hardQuestions
   * @param easyQuestions
   * @param fileName
   * @return
   * @throws IOException
   */
  public ArrayList<Question> questionsToShow(int size, ArrayList<Question> hardQuestions,
                                             ArrayList<Question> easyQuestions, String fileName)
      throws IOException {
    ArrayList<Question> result = new ArrayList<>();
    ArrayList<Question> unusedQuestions = new ArrayList<>();
    int totalQuestions = hardQuestions.size() + easyQuestions.size();
    int combinedSize = Math.min(size, totalQuestions);
    Collections.shuffle(hardQuestions);
    for (int i = 0; i < hardQuestions.size() && result.size() < size; i++) {
      result.add(hardQuestions.get(i));
    }
    Collections.shuffle(easyQuestions);
    for (int i = 0; i < easyQuestions.size() && result.size() < size; i++) {
      result.add(easyQuestions.get(i));
    }
    for (int i = result.size(); i < hardQuestions.size(); i++) {
      unusedQuestions.add(hardQuestions.get(i));
    }
    for (int i = Math.max(result.size() - hardQuestions.size(), 0); i < easyQuestions.size(); i++) {
      unusedQuestions.add(easyQuestions.get(i));
    }
    MdFileWriter.writeUnusedQuestionsToFile(unusedQuestions, fileName);
    return result;
  }
}











