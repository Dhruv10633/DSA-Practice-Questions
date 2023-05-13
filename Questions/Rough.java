import java.util.*;

public class Rough {

    public static int[] maxrevenue(int [][] sr){
        int ans[] = new int[sr.length];

        for(int i=0; i<sr.length; i++){
            int maxR = sr[i][0];
            for(int j=0; j<sr[i].length; j++){
                maxR = Math.max(maxR, sr[i][j]); 
            }
            ans[i] = maxR;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(order(0));

    }
}
