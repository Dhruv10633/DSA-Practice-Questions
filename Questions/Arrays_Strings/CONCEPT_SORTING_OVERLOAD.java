//https://hack.codingblocks.com/app/contests/3830/176/problem
package Arrays_Strings;

import java.util.*;
class Main {
    private static class emp{
        String name;
        int sal;
        emp(String n,int s){
            name=n;
            sal=s;
        }
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int limit=sc.nextInt();
        int n=sc.nextInt();

        ArrayList<emp> sal=new ArrayList<>();

        for(int i=0;i<n;i++){
            sal.add(new emp(sc.next(), sc.nextInt()));
        }

        Collections.sort(sal, new Comparator<emp>(){
            @Override
            public int compare(emp a,emp b){
                if(a.sal==b.sal){
                    return a.name.compareTo(b.name);
                }
                else{
                    return (b.sal)-(a.sal);
                }
            }
        });

        for(int i=0;i<n;i++){
            if(sal.get(i).sal < limit) break;
            System.out.println(sal.get(i).name+" "+sal.get(i).sal);
        }

        sc.close();

    }
}

