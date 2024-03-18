package cs3500.pa01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class StudySession {
  private final Reader input;
  private final Appendable output;
  private final ArrayList<Question> newFile;

  StudySession(Reader input, Appendable output) {
    this.input = input;
    this.output = output;
    this.newFile = new ArrayList<Question>();
  }

  /**
   * runs the program
   *
   * @throws IOException
   */
  public void run() throws IOException {
    BufferedReader reader = new BufferedReader(input);
    output.append("How many questions would you like?");
    System.out.println();

    // gets how many questions user would like
    int totalQuestions = Integer.parseInt(reader.readLine());
    output.append("What is the path to the file you would like to study");
    System.out.println();

    // Separates a question bank into easy and hard questions
    String filePath = reader.readLine();
    QuestionFileReader qfr = new QuestionFileReader(filePath);
    int initialHard = qfr.getHard(filePath);
    int initialEasy = qfr.getEasy(filePath);
    QuizMaker quiz = new QuizMaker(filePath);
    ArrayList<Question> hard = quiz.getHardQuestions();
    ArrayList<Question> easy = quiz.getEasyQuestions();

    // gets the hard and easy questions and combines it into the random question bank
    ArrayList<Question> questionToShow = quiz.questionsToShow(totalQuestions, hard, easy, filePath);
    runQuestions(questionToShow, reader, output, filePath, initialHard, initialEasy);

    reader.close();
    System.exit(0);
  }

  /**
   * runs the question part of the program
   *
   * @param questions
   * @param reader
   * @param output
   * @param filePath
   * @param initialHard
   * @param initialEasy
   * @throws IOException
   */
  private void runQuestions(ArrayList<Question> questions, BufferedReader reader,
                            Appendable output, String filePath, int initialHard, int initialEasy)
      throws IOException {
    ArrayList<Question> newFile = new ArrayList<>();
    int count = 0;
    int hardToEasy = 0;
    int easyToHard = 0;

    for (int i = 0; i < questions.size(); i++) {
      Question currentQuestion = questions.get(i);
      // Display the question
      output.append(currentQuestion.getQuestion() + "\n");

      // Show the options to the user
      output.append("Type 1 to mark as hard\n");
      output.append("Type 2 to mark as easy\n");
      output.append("Type 3 to see the answer\n");
      output.append("Type 4 to end the session\n");

      String answer = reader.readLine();

      if (answer.equals("1")) {
        if (questions.get(i).getType().toLowerCase().equals("easy")) {
          easyToHard++;
        }
        output.append("Question marked as hard\n\n");
        HardQuestion hq = new HardQuestion(currentQuestion.getQuestion(), currentQuestion.getAnswer());
        newFile.add(hq);
        count++;
      } else if (answer.equals("2")) {
        if (questions.get(i).getType().toLowerCase().equals("hard")) {
          hardToEasy++;
        }
        output.append("Question marked as easy\n\n");
        EasyQuestion eq = new EasyQuestion(currentQuestion.getQuestion(), currentQuestion.getAnswer());
        newFile.add(eq);
        count++;
      } else if (answer.equals("3")) {
        output.append(currentQuestion.getAnswer() + "\n");
        output.append("Type 1 to mark as hard, Type 2 to mark as easy\n");
        String response = reader.readLine();
        if (response.equals("1")) {
          if (questions.get(i).getType().equalsIgnoreCase("easy")) {
            easyToHard++;
          }
          output.append("Question marked as hard\n\n");
          HardQuestion hq = new HardQuestion(currentQuestion.getQuestion(), currentQuestion.getAnswer());
          newFile.add(hq);
          count++;
        } else if (response.equals("2")) {
          if (questions.get(i).getType().equalsIgnoreCase("hard")) {
            hardToEasy++;
          }
          output.append("Question marked as easy\n\n");
          EasyQuestion eq = new EasyQuestion(currentQuestion.getQuestion(), currentQuestion.getAnswer());
          newFile.add(eq);
          count++;
        }
      } else if (answer.equals("4")) {
        printStats(count, hardToEasy, easyToHard, initialHard, initialEasy);
        newFile.add(currentQuestion);
        for (int j = i + 1; j < questions.size(); j++) {
          newFile.add(questions.get(j));
        }
        System.exit(0);
      } else {
        output.append("Invalid response: Nothing done\n");
      }
    }
    printStats(count, hardToEasy, easyToHard, initialHard, initialEasy);
    MdFileWriter.addQuestionsToFile(newFile, filePath);
  }

  /**
   * prints out the final stats
   *
   * @param count
   * @param hardEasy
   * @param easyHard
   * @param initialHard
   * @param initialEasy
   * @throws IOException
   */
  private void printStats(int count, int hardEasy,
                          int easyHard, int initialHard, int initialEasy) throws IOException {
    output.append("Questions answered: " + count + "\n");
    output.append("Questions from hard to easy: " + hardEasy + "\n");
    output.append("Questions from easy to hard: " + easyHard + "\n");
    output.append("There are now " + (initialHard - hardEasy + easyHard) + " hard questions\n");
    output.append("There are now " + (initialEasy - easyHard + hardEasy) + " easy questions\n");
  }


}
