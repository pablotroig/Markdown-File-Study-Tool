package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class StringUtilTest {

  @Test
  public void bracketExtractorTest() {
    String testString = "[[Hello there]] this [[is a test]]";
    ArrayList<String> extracted = new ArrayList<>();
    extracted.add("Hello there");
    extracted.add("is a test");
    assertEquals(extracted, StringUtil.bracketExtractor(testString));
    String testString2 = "There are no brackets";
    ArrayList<String> empty = new ArrayList<>();
    assertEquals(empty, StringUtil.bracketExtractor((testString2)));
    String testString3 = "This is a [[test";
    assertEquals(empty, StringUtil.bracketExtractor(testString3));
    String testString4 = "This is a test]]";
    assertEquals(empty, StringUtil.bracketExtractor(testString4));
  }

  @Test
  public void countBracketsTest() {
    String testString1 = "[[This is]] a [[test]]";
    assertEquals(4, StringUtil.countBrackets(testString1));
    String testString2 = "Empty";
    assertEquals(0, StringUtil.countBrackets(testString2));
    String testString3 = "[[This is a test";
    assertEquals(1, StringUtil.countBrackets(testString3));
    String testString4 = "This is a test]]";
    assertEquals(1, StringUtil.countBrackets(testString4));
  }

  @Test
  public void findLastOccurenceTest() {
    String testString = "this is a test]]";
    assertEquals(14, StringUtil.findLastOccurrence(testString, "]]"));
    String testString2 = "this ]] is a test ]]";
    assertEquals(18, StringUtil.findLastOccurrence(testString2, "]]"));
    String testString3 = "this is a test";
    assertEquals(-1, StringUtil.findLastOccurrence(testString3, "]]"));
  }
}

