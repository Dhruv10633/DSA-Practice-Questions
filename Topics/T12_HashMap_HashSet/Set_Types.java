package Topics.T12_HashMap_HashSet;

import java.util.*;

public class Set_Types {
    

    public static void hashSet() {
        HashSet<Integer> set= new HashSet<>();

        set.add(90);
        set.add(12);
        set.add(24);
        set.add(43);
        set.add(null);

        //HashSet stores all elements in random order
        //Can contain null
        //All Operations TC:O(1)
    }

    public static void treeSet() {
        TreeSet<Integer> set= new TreeSet<>();

        set.add(90);
        set.add(12);
        set.add(24);
        set.add(43);
        set.add(null);

        //TreeSet stores all elements in sorted order
        //Cannot contain null
        //All Operations TC:O(log n)
    }

    public static void linkedHashSet() {
        LinkedHashSet<Integer> set= new LinkedHashSet<>();

        set.add(90);
        set.add(12);
        set.add(24);
        set.add(43);
        set.add(null);

        //LinkedHashSet stores all elements in insertion
        //Can contain null
        //All Operations TC:O(1)
    }
}
