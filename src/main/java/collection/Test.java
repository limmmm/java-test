package collection;

import java.util.*;

/**
 * @author Lim
 * @date 2020/5/7
 */
public class Test {
    public static void main(String[] args) {
        Set<String> sa = new HashSet<>();
        Set<String> sb = new TreeSet<>();
        Set<String> sc = new LinkedHashSet<>();

        List<String> la = new ArrayList<>();
        List<String> lb = new LinkedList<>();

        Map<String, String> ma = new HashMap<>();
        ma.put("a", "a");
        Map<String, String> mb = new LinkedHashMap<>();
        Map<String, String> mc = new TreeMap<>();
        Map<String, String> md = new Hashtable<>();
    }
}
