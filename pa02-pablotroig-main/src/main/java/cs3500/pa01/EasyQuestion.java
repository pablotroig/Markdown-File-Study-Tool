package cs3500.pa01;

public class EasyQuestion extends Question{
  /**
   * @param question is the question being asker
   * @param answer   is the answer to the question
   */
  EasyQuestion(String question, String answer) {
    super(question, answer);
  }

  @Override
  public String getType() {
    return "Easy";
  }

}
