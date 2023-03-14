//https://hack.codingblocks.com/app/contests/3830/966/problem
package Arrays_Strings;

import java.util.*;
class Main {

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        ArrayList<String> sal=new ArrayList<>();

        for(int i=0;i<n;i++){
            sal.add(sc.next());
        }

        Collections.sort(sal, new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                if(a.charAt(0)==b.charAt(0)){
                    
                    for(int i=0 ; i < a.length() || i < b.length() ; i++){
                        if(i==a.length() || i==b.length()){
                            return b.length()-a.length();
                        }
                        if(a.charAt(i)!=b.charAt(i)) break;
                    }
                    return a.compareTo(b);
                }
                else{
                    return a.compareTo(b);
                }
            }
        });

        for(int i=0;i<n;i++){
            System.out.println(sal.get(i));
        }

        sc.close();

    }
}

