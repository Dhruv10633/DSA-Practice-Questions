// https://leetcode.com/problems/boats-to-save-people/description/
package Arrays_Strings;
import java.util.*;

class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i=0, j=people.length-1, boats=0;

        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
                boats++;
            }
            else{
                j--;
                boats++;
            }
        }
        return boats;
    }
}
