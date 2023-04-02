// https://leetcode.com/problems/decode-string/
package Recursion_Backtracking;
import java.util.*;

class Solution1 {

    //////Recursive
    private int i=0;

    public String decodeString(String s) {
        
        StringBuilder res= new StringBuilder();

        //we havent solved our prob till we reach this
        while(i<s.length() && s.charAt(i)!=']'){
            if(!Character.isDigit(s.charAt(i))){
                res.append(s.charAt(i));
                i++;
            }
            else{
                int k=0;
                while(Character.isDigit(s.charAt(i))){
                    k=k*10 + s.charAt(i)-'0';
                    i++;
                }
                //For '['
                i++;
                String dstr=decodeString(s);

                while(k-->0){
                    res.append(dstr); 
                }
                i++;
            }
        }
        return new String(res);
    }
}


class Solution2 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
