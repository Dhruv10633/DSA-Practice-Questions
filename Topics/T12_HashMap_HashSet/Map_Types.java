package Topics.T12_HashMap_HashSet;

import java.util.*;

public class Map_Types {
    //Diff between a class with key and val and Hash Map:

    //All hashmap operations like remove insert and find happen in O(1)
    //whereas if we take an array of objects we would take O(N) time to find, insert and delete

    public static void hashMap(){
        HashMap <String,Integer> hmap=new HashMap<>();
        //Insertion
        hmap.put("Ram",89);
        hmap.put("Raj",89);
        hmap.put("Dhruv", 91);
        hmap.put("Ramesh",34);
        hmap.put(null,34);  //works fine in hmap

        System.out.println(hmap);

        //Deletion (returns val correspond to key deleted)
        hmap.remove("Ram");

        //accessing
        hmap.get("Ram");

        //check if key present (Bool)
        hmap.containsKey("Ramu");
        //check if val present (Bool)
        hmap.containsValue(91);

        //Traversal
        Set<String> s=hmap.keySet();

        for(String k: s){
            System.out.println(k +" "+ hmap.get(k));
        }

        //hmap stores the elements randomly (in no order) 
        //accept null as key
        //TC for all operation : O(1)

    }

    public static void treeMap(){
        TreeMap <String,Integer> tmap=new TreeMap<>();
        //Insertion
        tmap.put("Ram",89);
        tmap.put("Raj",89);
        tmap.put("Dhruv", 91);
        tmap.put("Ramesh",34);
        tmap.put(null,34);  //gives error in tmap

        //Tmap sorts the map acc to key
        //does not accept null as key
        //TC for all operation : O(log n)
    }


    public static void linkedHashMap(){
        LinkedHashMap <String,Integer> lmap=new LinkedHashMap<>();
        //Insertion
        lmap.put("Ram",89);
        lmap.put("Raj",89);
        lmap.put("Dhruv", 91);
        lmap.put("Ramesh",34);
        lmap.put(null,34);  //fine in lmap

        //lmap preserves the the insertion order 
        //accept null as key
        //TC for all operation : O(1)
    }




    public static void main(String[] args) {
        hashMap();
        treeMap();
        linkedHashMap();
    }
}
