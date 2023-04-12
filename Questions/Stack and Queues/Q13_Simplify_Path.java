// https://leetcode.com/problems/simplify-path/description/
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<path.length();){
            char temp = path.charAt(i);

            if(temp=='/'){
                while(i<path.length() && path.charAt(i)=='/'){
                    i++;
                }
            }
            else{
                StringBuilder d = new StringBuilder();
                while(i<path.length() && path.charAt(i)!='/'){
                    d.append(path.charAt(i));
                    i++;
                }

                String temp2 = new String(d);
                
                // then we need to go to parent directory
                if(temp2.equals("..")){
                    if(!dir.isEmpty())dir.pop();
                }
                // if it is not '.' which means curr directory then we consider it a new directory name
                else if(!temp2.equals(".")){
                    dir.push(temp2);
                }  
            }
        }
    
        if(dir.isEmpty()){
            ans.append('/');
            return new String(ans);
        }

        for(String x:dir){
            ans.append('/'+x);
        }
        return new String(ans);
    }
}
