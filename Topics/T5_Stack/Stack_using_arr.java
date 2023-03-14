import java.util.*;

public class Stack_using_arr{
    
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.pop();
        Stack_using_arr obj=new Stack_using_arr();
        //every class inherits the object properties which has "toString()" which prints the below ans
        //U can override that "toString()" by creating a custom one
        System.out.println(obj);
    }
}
