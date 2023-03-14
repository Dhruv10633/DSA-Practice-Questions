//https://leetcode.com/problems/restore-ip-addresses/description/
package Recursion_Backtracking;
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        return IpAdd(s, 4, "");
    }

    private List<String> IpAdd(String s,int cnt,String i){
        List<String> ans=new ArrayList<>();
        if(s.length()==0 || cnt==0){
            if(s.length()==0 && cnt==0) ans.add(i);
            return ans;
        }

        if(s.length()>=1){
            String temp = s.substring(0,1);

            if(i.length()==0) temp = s.substring(0,1);  
            else temp = i+"."+s.substring(0,1);

            List<String> t1 = IpAdd(s.substring(1), cnt-1, temp);
            if(!t1.isEmpty()){
                for(String t:t1){
                    ans.add(t);
                }
            }
        }
        if(s.length()>=2 && s.charAt(0) !='0'){
            String temp = s.substring(0,2);

            if(i.length()==0) temp = s.substring(0,2);  
            else temp = i+"."+s.substring(0,2);

            List<String> t1 = IpAdd(s.substring(2), cnt-1, temp);
            if(!t1.isEmpty()){
                for(String t:t1){
                    ans.add(t);
                }
            }
        }
        if(s.length()>=3 && Integer.parseInt(s.substring(0,3)) <= 255 && s.charAt(0) !='0' ){
            String temp = s.substring(0,3);
            
            if(i.length()==0) temp = s.substring(0,3);  
            else temp = i+"."+s.substring(0,3);

            List<String> t1 = IpAdd(s.substring(3), cnt-1, temp);
            if(!t1.isEmpty()){
                for(String t:t1){
                    ans.add(t);
                }
            }
        }
        return ans;
    }
}
