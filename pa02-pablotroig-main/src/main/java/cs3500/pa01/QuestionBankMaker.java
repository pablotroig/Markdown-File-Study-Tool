package cs3500.pa01;

import java.util.ArrayList;

public class QuestionBankMaker {
  ArrayList<String> questionsAndNotes;
  QuestionBankMaker(ArrayList<String> questionsAndNotes) {
    this.questionsAndNotes = questionsAndNotes;
  }

  public ArrayList<Question> makeInitialQuestionBank(){
    ArrayList<Question> qb = new ArrayList<Question>();
    for (String questionsAndNote : questionsAndNotes) {
      if (StringUtil.isQuestion(questionsAndNote)) {
        String current = questionsAndNote;
        int index = current.indexOf(":::");
        HardQuestion hq = new HardQuestion(current.substring(2, index),
            current.substring(index + 3));
        qb.add(hq);
      }
    }
    return qb;
  }
}

