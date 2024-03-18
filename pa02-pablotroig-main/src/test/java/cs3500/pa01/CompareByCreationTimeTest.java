package cs3500.pa01;


import java.io.File;
import java.nio.file.attribute.FileTime;

class CompareByCreationTimeTest {
  static final String SAMPLE_INPUTS_DIRECTORY = "src/test/resources/inputs/";
  File mdFile;
  FileTime ft1;
  PathAndTime pat;

  /*
  @Test
  public void CompareByCreationTimeCompareTest() throws IOException {
    mdFile = File.createTempFile("test", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    ft1 = Files.readAttributes(mdFile.toPath(), BasicFileAttributes.class).creationTime();
    pat = new PathAndTime(mdFile.toPath(), ft1);
    File mdFile2 = File.createTempFile("aTest", ".md", new File(SAMPLE_INPUTS_DIRECTORY));
    FileTime ft2 = Files.readAttributes(mdFile2.toPath(), BasicFileAttributes.class).creationTime();
    PathAndTime pat2 = new PathAndTime(mdFile2.toPath(), ft2);
    assertEquals(0, new CompareByCreationTime().compare(pat, pat2));
    FileTime ft3 = FileTime.from(Instant.parse("2023-04-14T12:00:00Z"));
    PathAndTime pat3 = new PathAndTime(mdFile.toPath(), ft3);
    assertEquals(-1, new CompareByCreationTime().compare(pat3, pat2));
    assertEquals(1, new CompareByCreationTime().compare(pat2, pat3));
    mdFile.deleteOnExit();
    mdFile2.deleteOnExit();
  } */
}