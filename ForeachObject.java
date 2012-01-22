import java.lang.Iterable;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class ForeachObject<T> {
  public void foreachOfArrayOfObjects(T[] before, ForeachObject<T> mapper) {
    for (int i = 0; i < before.length; i++) {
      mapper.handleObject(before[i]);
    }
  }

  public void foreachOfListOfObjects(
      List<T> before, ForeachObject<T> mapper) {
    for (T eachElement : before) {
      mapper.handleObject(eachElement);
    }
  }

  public void foreachOfIterableOfObjects(
      Iterable<T> iterable, ForeachObject<T> mapper) {
    Iterator<T> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      T next = iterator.next();
      mapper.handleObject(next);
    }
  }

  public void foreachOfEnumerationOfObjects(
      Enumeration<T> enumeration, ForeachObject<T> mapper) {
    while (enumeration.hasMoreElements()) {
      T next = enumeration.nextElement();
      mapper.handleObject(next);
    }
  }

  // This method gets overridden; it should be abstract, except that makes it
  // harder to instantiate the class.
  public void handleObject(T _) { }
}
