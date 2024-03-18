package cs3500.pa01;

class CompareByLastModifiedTest {
  static final String SAMPLE_INPUTS_DIRECTORY = "src/test/resources/inputs/";

  /*
  @Test
  public void CompareByLastModifiedTCompareests() throws IOException {
    File mdFile1 = File.createTempFile("test", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    File mdFile2 = File.createTempFile("aTest", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    Integer int1 = (int)mdFile1.lastModified();
    Integer int2 = (int)mdFile2.lastModified();
    assertEquals(0, new CompareByLastModified().compare(int1, int2));
    boolean b1 = mdFile1.setLastModified(19283);
    boolean b2 = mdFile2.setLastModified(19284);
    assertEquals(true, b1);
    assertEquals(true, b2);
    Integer int3 = (int) mdFile1.lastModified();
    Integer int4 = (int) mdFile2.lastModified();
    assertEquals(1, new CompareByLastModified().compare(int3, int4));
    mdFile1.deleteOnExit();
    mdFile2.deleteOnExit();


  } */

}
