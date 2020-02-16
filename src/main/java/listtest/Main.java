package listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lim
 * @date: 2019/8/18
 */
public class Main {
    public static void main(String[] args) {
      List<ListA> list1 = new ArrayList<>();
//      list1.add(new ListA("1"));
//      list1.add(new ListA("2"));

      List<ListA> list2 = new ArrayList<>();
//      list2.add(new ListA());
      list1.addAll(list2);

      System.out.println(list1.toString());
      System.out.println(list2.toString());


    }
}
