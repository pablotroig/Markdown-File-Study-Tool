package cs3500.pa01;

public abstract class Question {
  private final String question;
  private final String answer;

  /**
   *
   * @param question is the question being asker
   * @param answer is the answer to the question
   */
  Question(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return this.question;
  }

  public String getAnswer() {
    return this.answer;
  }

  public String getType() {
    return "Hard";
  }



}
