// https://hack.codingblocks.com/app/contests/3681/556/problem
import java.util.*;

public class Q11_Playing_with_Stacks {

    public static boolean checkPrime(int n){
        if(n<2){
            return false;
        }

        for(int i=2 ; i<=Math.sqrt(n) ;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void playing_with_cards(Stack<Integer> cards,int q){
        Stack<Integer> A=new Stack<>();
        Stack<Integer> B=new Stack<>();

        // Stack<Integer> fin=new Stack<>();

        int prime=2;

        while(q--!=0){
            //getting the ith prime num
            while(!checkPrime(prime)){
                prime++;
            }

            //now playing with cards
            while(!cards.isEmpty()){
                int top=cards.pop();

                if(top % prime==0){
                    B.push(top);
                }
                else{
                    A.push(top);
                }
            }

            //We empty B stack as once printed we don't need again
            while(!B.isEmpty()){
                System.out.println(B.pop());
            }

            //Stack A represesnts left over cards 
            //we give the left over cards back to cards stack and empty A
            cards=A;
            A=new Stack<>();

            //Getting new prime
            prime++;
        }
        while(!cards.isEmpty()){
            System.out.println(cards.pop());
        }
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        // int n=sc.nextInt();
        int q=sc.nextInt();

        Stack<Integer> cards=new Stack<>();

        while(sc.hasNext()){
            cards.push(sc.nextInt());
        }
        
        playing_with_cards(cards,q);
        sc.close();
    }
}

