import java.lang.reflect.Array;

public class MapNoPrimitives<T,U> {
  @SuppressWarnings({"unchecked"})
  public U[] mapTArrayToUArray(T[] before, Class<T> clazzT, Class<U> clazzU,
      MapNoPrimitives<T,U> mapper) {
    U[] after = (U[])Array.newInstance(clazzU, before.length);
    for (int i = 0; i < before.length; i++) {
      after[i] = mapper.mapTToU(before[i]);
    }
    return after;
  }

  // This method gets overridden; it should be abstract, except that makes it
  // harder to instantiate the class.
  public U mapTToU(T _) {
    return null;
  }
}
