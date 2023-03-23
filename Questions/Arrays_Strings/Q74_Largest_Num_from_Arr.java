// https://leetcode.com/problems/largest-number/
package Arrays_Strings;
import java.util.*;

class Solution {

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];         
        for(int i=0; i<nums.length; i++)  s[i] = ""+(nums[i]);
        Arrays.sort(s, (a,b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("",s);
    }
}