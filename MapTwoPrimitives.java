public class MapTwoPrimitives {
  public static int[] mapArrayOfIntsToArrayOfInts(
      int[] before, MapTwoPrimitives mapper) {
    int[] after = new int[before.length];
    for (int i = 0; i < before.length; i++) {
      after[i] = mapper.mapIntToInt(before[i]);
    }
    return after;
  }

  // This method gets overridden; it should be abstract, except that makes it
  // harder to instantiate the class.
  public int mapIntToInt(int _) {
    return 0;
  }
}
