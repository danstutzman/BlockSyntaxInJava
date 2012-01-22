public class ForeachPrimitive {
  public static void foreachOfArrayOfInts(int[] before,
      ForeachPrimitive mapper) {
    for (int i = 0; i < before.length; i++) {
      mapper.handleInt(before[i]);
    }
  }

  // This method gets overridden; it should be abstract, except that makes it
  // harder to instantiate the class.
  public void handleInt(int _) { }
}
