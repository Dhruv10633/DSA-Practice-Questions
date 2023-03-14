//https://leetcode.com/contest/weekly-contest-325/problems/shortest-distance-to-target-string-in-a-circular-array/
package Arrays_Strings;

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return -1;
        }
        
        
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                
                int distance = Math.min(Math.abs(startIndex - i), n - Math.abs(startIndex - i));
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }
}
