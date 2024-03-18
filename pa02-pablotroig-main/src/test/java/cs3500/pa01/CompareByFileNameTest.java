package cs3500.pa01;

// passes in here but fails to build?
class CompareByFileNameTest {
  static final String SAMPLE_INPUTS_DIRECTORY = "src/test/resources/inputs/";
  /*
  @Test
  public void CompareByFileNameCompareTest() throws IOException {
    File mdFile1 = File.createTempFile("test", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    File mdFile2 = File.createTempFile("aTest", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    String str1 = mdFile1.toPath().getFileName().toString();
    String str2 = mdFile2.toPath().getFileName().toString();
    assertEquals(19, new CompareByFileName().compare(str1, str2));
    assertEquals(-19, new CompareByFileName().compare(str2, str1));
    assertEquals(0, new CompareByFileName().compare(str1, str1));
    mdFile1.deleteOnExit();
    mdFile2.deleteOnExit();
  } */
}