//https://leetcode.com/problems/path-sum-ii/description/
package Binary_Trees;
import java.util.*;

public class Q3_Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> li=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
         
        return pathSum(root,targetSum,li,ans);
 
    }

    public List<List<Integer>> pathSum(TreeNode root, int targ, List<Integer> li, List<List<Integer>> ans){
        if(root==null){   
            return ans;
        }

        targ-=root.val;
        li.add(root.val);

        if(root.left==null && root.right==null){
            if(targ==0){
                //Deep copy of the ll
                List<Integer> f_li=new ArrayList<>(li);
                ans.add(f_li);      
            }

            //this is is imp as for the leaf nodes we never reach null and return here back to the root node
            //and thus the leaf nodes never get removed as it never reaches the li.remove() at line 35(or the 2nd last line) 
            //so we need to manually do that here
            li.remove(li.size()-1);
            return ans;
        }
        

        pathSum(root.left,targ,li,ans);
        pathSum(root.right,targ,li,ans);
        
        li.remove(li.size()-1);

        return ans;
        
    }
    
}
