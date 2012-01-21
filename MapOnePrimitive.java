import java.lang.reflect.Array;

public class MapOnePrimitive<T> {
  @SuppressWarnings({"unchecked"})
  public T[] mapIntArrayToTArray(
      int[] before, Class<T> clazz, MapOnePrimitive<T> mapper) {
    T[] after = (T[])Array.newInstance(clazz, before.length);
    for (int i = 0; i < before.length; i++) {
      after[i] = mapper.mapIntToT(before[i]);
    }
    return after;
  }

  // This method gets overridden; it should be abstract, except that makes it
  // harder to instantiate the class.
  public T mapIntToT(int _) {
    return null;
  }
}
