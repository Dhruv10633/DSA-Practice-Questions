//https://leetcode.com/problems/path-sum-iii/description/

package Binary_Trees;
import java.util.*;

public class Q4_Path_Sum_III {

    //Brute force (O(n^2))
    // public int pathSum(TreeNode root, int targSum) {
    //     if(root==null){
    //         return 0;
    //     }

    //     //similar to n^2 2 for loops 1 ,i from 0 to n ,2 ,then 1 to n ,just here we have left and right instead of i+1
    //     int ans = checkS(root,targSum);
        
    //     ans += pathSum(root.left,targSum);
    //     ans += pathSum(root.right,targSum);

    //     return ans;
    // }

    // //returns the possible routed with targ sum
    // private int checkS(TreeNode root,long targSum){
    //     int ans=0;
    //     if(root==null){
    //         return ans;
    //     }

    //     targSum-=root.val;

    //     if(targSum==0){
    //         ans++;
    //     }
    //     ans += checkS(root.left,targSum) + checkS(root.right,targSum);
    //     return ans;

    // }

    //Optimised (O(N))
    public int pathSum(TreeNode root, int targ, long  sum ,Map<Long,Integer> presum){
        if(root==null){
            
            return 0;
        }
        
        sum+=root.val; 
        int count=0;
        if(presum.containsKey(sum-targ)){
            count=presum.get(sum-targ);
        }

        presum.put(sum, presum.getOrDefault(sum,0)+1);

        count+= (pathSum(root.left, targ,sum,presum) + pathSum(root.right,targ,sum,presum));

        //We do this even if we are just going up cause we need the presum map empty for the right side
        if(presum.get(sum)==1)  presum.remove(sum);
        else presum.put(sum, presum.get(sum)-1);

        return count;
    }
}
