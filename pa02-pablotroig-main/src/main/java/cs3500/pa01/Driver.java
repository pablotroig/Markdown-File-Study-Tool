package cs3500.pa01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - 3 command line args required
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 0) {
      Path filePath = Path.of(args[0]);
      MarkDownFileVisitor md = new MarkDownFileVisitor();
      Files.walkFileTree(filePath, md);
      StudyGuideMaker sgm = new StudyGuideMaker(md.getPathList(args[1]), md.getCount(), args[1]);
      QuestionBankMaker qbm = new QuestionBankMaker(sgm.makeStudyGuide());
      ArrayList<String> studyGuide = StringUtil.filterQuestion(sgm.makeStudyGuide());
      studyGuide = StringUtil.filterQuestion(studyGuide);
      ArrayList<Question> questions = qbm.makeInitialQuestionBank();
      MdFileWriter.writeFile(args[2], studyGuide, questions);
    } else {
      StudySession quizRunner =
          new StudySession(new InputStreamReader(System.in), new PrintStream(System.out));
      quizRunner.run();
    }
  }
}