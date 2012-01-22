import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadmeExampleBefore {
  public static void main(String[] args) {
    new ReadmeExampleBefore().main();
  }

  public void main() {
    List<Integer> ints = Arrays.asList(new Integer[] { 1, 2, 3 });
    System.out.println(ints);

    List<Integer> negativeInts = map(ints, new IntTransformer() {
      public int transform(int _) {
        return -_;
      }
    });
    System.out.println(negativeInts);
  }

  private static List<Integer> map(List<Integer> ints,
      IntTransformer transformer) {
    List<Integer> output = new ArrayList<Integer>(ints.size());
    for (Integer i : ints) {
      output.add(transformer.transform(i));
    }
    return output;
  }

  abstract class IntTransformer {
    abstract int transform(int _);
  }
}
