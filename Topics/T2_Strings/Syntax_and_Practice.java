import java.util.*; 

public class Syntax_and_Practice {
    public static void main(String[] args) {
        //STRINGS are immutable

        //creates a new string object
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1==s2);           //it compares the addresses

        //creates a string oject in "string pool" in heap
        // here both s3 ,s4 has same address for strings
        String s3="xyz";
        String s4="xyz";
        System.out.println(s3==s4);           //it compares the addresses

        //meth 3 to create string;
        char[] a={'1','2','3'};
        String s5=new String(a);
        
        //string is stored as char arr in backend
        //charAt() : is used to access the char at that string pos
        System.out.println(s5+s5.charAt(0));

        //take input string without space;
        Scanner sc=new Scanner(System.in);
        String s6=sc.next();
        sc.nextLine();          //use this if u need sc.nextLine() so when we press enter after next it doesn't exit;
        System.out.println(s6);

        //take string with space
        String s7=sc.nextLine();
        System.out.println(s7);

        //reverse string;
        String s8="";
        for(int i=s5.length()-1 ; i>=0 ; i--){
            s8+=s5.charAt(i);                   //everytime a new string object is created and s8 is assigned the address of the new string object
        }
        System.out.println(s8);
        
        //.equals() to check if string char == to another string char (otherwise it checks only the addresses)
        //otherwise u need to run a for leep and check charAt dor both strings;
        s7.equals(s8);  

        //.equalsIgnoreCase() same as equals but ignores the case

        //.indexOf('c',2) - gets the index of the element 'c' or substring too in the string (case sensitiive)
        // after index 2
        String s9="abcbbe";
        System.out.println(s9.indexOf('b',2));

        //.substring(3,7) - gets the susbstring in this index
        String s10="Hello World";
        System.out.println(s10.substring(3,7));

        //s1.contains(s2) - check if s1 contains 
        String s11="orl";
        System.out.println(s10.contains(s11));

        //lastIndexOf() - checks for that element fromt he last place (similar to indexOf())
        
        //toLowerCase() ,toUpperCase()
        s11.toUpperCase();
        System.out.println(s11);  //here it prints original no change cause above only a copy of the string
                                  //is created and that is converted to Upper not the original string
        
        //charArray() - string to char array
        char[] ca=s11.toCharArray();
        
    }
}
