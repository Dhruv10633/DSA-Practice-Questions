// https://leetcode.com/problems/sort-characters-by-frequency/
package Arrays_Strings;
import java.util.*;

public class Q13_Sort_String_acc_to_freq {

    public static String frequencySort(String s) {
        Map<String,Integer> map=new HashMap<>();

        for(int i=0; i<s.length() ; i++){
            String temp=""+s.charAt(i);
            map.put(temp, map.getOrDefault(temp,0)+1);
        }

        //looping over keys of map just to check
        // for(char ch:map.keySet()){
        //     System.out.println(ch+" "+ map.get(ch));
        // }   
        
        map=sortByVal(map);

        StringBuilder ans=new StringBuilder();

        
        
        for(String temp:map.keySet()){
            int temp2=map.get(temp);
            while(temp2--!=0){
                ans.append(temp);
            }
        }

        return ans.toString();
    }

    private static Map<String,Integer> sortByVal (Map<String,Integer> mp){

        //List of map entries(key val pairs) ("Map.Entry<String,Integer>")
        List<Map.Entry<String,Integer>> list = new LinkedList<>(mp.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            //to override the default compare func
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        // lambda is slower than the anonymous class
        // Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        Map<String,Integer> newMp = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry:list){
            newMp.put(entry.getKey(), entry.getValue());
        }
        
        return newMp;
            
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=sc.next();

        System.out.println(frequencySort(s));
        sc.close();
    }

}
