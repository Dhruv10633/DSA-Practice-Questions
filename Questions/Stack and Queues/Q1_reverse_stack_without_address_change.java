import java.util.*;


public class Q1_reverse_stack_without_address_change {
    //static keyword pemans this func can be used anywhere without using classname.func() and just func().
    public static void reverPrint(Stack<Integer> st){
        if(st.empty()){
            return;
        }
        int x=st.pop();  // pop returns the value here

        reverPrint(st);
        //this below step is imp as otherwise stack would be empty 
        st.push(x);
        System.out.println(st.peek());         
    }

    public static void copy(Stack<Integer> st,Stack<Integer> st2){
        if(st.empty()){
            return;
        }
        int x=st.pop();  // pop returns the value here

        copy(st,st2);
        //this below step is imp as otherwise stack would be empty 
        st2.push(x);
                 
    }

    //using 2 stacks
    public static void reverStack_recurs(Stack<Integer> st) {
        Stack<Integer> st2=new Stack<>();
        copy(st,st2);

        System.out.println(st);
        System.out.println(st2);

        while(!st2.empty()){
            st.push(st2.pop());
        }
        System.out.println(st);
            
    }

    //using 3 stacks
    public static void reverStack_iter(Stack<Integer> st) {
        Stack<Integer> st2=new Stack<>();
        Stack<Integer> st3=new Stack<>();
        

        while(!st.empty()){
            st2.push(st.pop());
        }
        while(!st2.empty()){
            st3.push(st2.pop());
        }
        while(!st3.empty()){
            st.push(st3.pop());
        }
        System.out.println(st);
            
    }

    //using 1 stack (space efficient)
    public static void bottom(Stack<Integer> st,int x) {
        if(st.isEmpty()){
            //to enter the x at bottom 
            st.push(x);
            return;
        }
        //to pop all elements
        int y=st.pop();
        bottom(st,x);
        st.push(y);
    }
    public static void reverse(Stack<Integer> st) {
        //it pops top ele assuming that n-1 stack is reversed
        if(st.isEmpty()){
            return;
        }
        int x=st.pop();
        reverse(st);
        //bottom removes all the previous ele in stack and it enters the x elemnt at the bottom of the stack
        bottom(st,x);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            st.push(sc.nextInt());
        }
        
        sc.close();
        reverPrint(st);
        System.out.println();
        // reverStack_recurs(st);
        // reverStack_iter(st);
        reverse(st);
        System.out.println(st);
        

    }
}
