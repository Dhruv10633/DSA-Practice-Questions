package Arrays_Strings;
// import java.util.*;

public class Q17 {
    
    private static void longest_substr(String[] arr,String str) {
        String ans="";

        for(int i=0;i<arr.length;i++){

            if(found(arr[i],str)){
                
                if(arr[i].length() > ans.length()){
                    ans=arr[i];
                }
                else if(arr[i].length() == ans.length()){
                    if(arr[i].compareTo(ans)<0){
                        ans=arr[i];
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean found(String s1,String s2){

        int k=0;
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==s1.charAt(k)){
                k++;

                if(k==s1.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr={"ale","aple","monkey","plea"};

        String str="abcplea";

        longest_substr(arr, str);
    }
}
