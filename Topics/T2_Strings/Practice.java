import java.util.*;

public class Practice {
    public static void main(String[] args) {
        //How to take character input:
        Scanner sc=new Scanner(System.in);

        //To check if 1 string present in another string
        String s1="Hello World";
        String s2="orl";

            //Method 1
            // for(int i=0;i<s1.length();i++){
                
            //     if(s1.charAt(i)==s2.charAt(0)){
            //         int k=i;
            //         Boolean chk=true;
            //         for(int j=0 ; j<s2.length() && k<s1.length() ; j++,k++){
            //             if(s1.charAt(k)!=s2.charAt(j)){
            //                 chk=false;
            //                 break;
            //             }
            //         }
            //         if(chk){
            //             System.out.println("Found  at " + i);
            //             return ;
            //         }
            //     }
            // }

            //Meth 2
            // for(int i=0;i<s1.length()-s2.length()+2;i++){
            //     if(s2.equals(s1.substring(i,i+s2.length()))){
            //         System.out.println("Found  at " + i);
            //         break;
            //     }
            // }

            // //Method 3
            // System.out.println(s1.contains(s2));
            
            // Check if Valid email
            String s3=sc.next();

            int i=0;
            if(s3.indexOf('@')!=0 && s3.indexOf('@')!=-1){
                i=s3.indexOf('@');
                if(s3.indexOf('.')!=s3.length()-1 && s3.indexOf('.')!=-1){
                    System.out.println("True");
                    return;
                }
            }
            
            System.out.println("False");
            
            

    }
}
