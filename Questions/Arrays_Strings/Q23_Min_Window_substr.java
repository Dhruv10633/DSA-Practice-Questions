//https://leetcode.com/problems/minimum-window-substring/description/

package Arrays_Strings;
import java.util.*;

public class Q23_Min_Window_substr{

    private int k=0;

    private int slider(String s,Map<Character,Integer> map ,int start ,int i){
        while(k==0){
            char temp=s.charAt(start);

            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
                if(map.get(temp)>0){
                    k++;
                }
            }

            start++;
        }

        return start;
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0 ; i<t.length() ;i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        k=map.size();
        int start=0;
        String min_str="";
        int min_s=Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);

            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)-1);

                if(map.get(temp)==0) k--;

                if(k==0){
                    start=slider(s,map,start,i);

                    if(i-(start-1)+1 < min_s){
                        min_s=i-(start-1)+1;

                        min_str="";

                        for(int j=(start-1);j<=i;j++){
                            min_str+=s.charAt(j);
                        }
                    }
                    
                }
            }
        }

        if(k>0) return min_str; 

        int n=s.length()-1;

        start=slider(s,map,start,n);
        if(n-(start-1)+1 < min_s){
            min_s=n-start+1;
            min_str="";

            for(int j=start;j<=n;j++){
                min_str+=s.charAt(j);
            }
        }
    
        return min_str;
        
    }
}