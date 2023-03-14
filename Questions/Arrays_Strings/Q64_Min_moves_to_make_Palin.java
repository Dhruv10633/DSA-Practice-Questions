package Arrays_Strings;

class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] str = new char[s.length()];
        for(int i=0;i<s.length();i++){
            str[i]=s.charAt(i);
        }

        int i=0, j=s.length()-1;
        int count=0;

        while(i<j){
            if(str[i] != str[j]){
                //we check from i till we find the char at j
                int s1=i, c1=0;
                while(str[s1]!=str[j]){
                    s1++;
                    c1++;
                }

                //vice versa
                int s2=j, c2=0;
                while(str[s2]!=str[i]){
                    s2--;
                    c2++;
                }

                //whichever takes less swap steps we do the swapping
                if(c1<=c2){
                    int temp=s1;
                    while(temp>i){
                        char swap = str[temp];
                        str[temp] = str[temp-1];
                        str[temp-1] = swap;
                        temp--;
                    }
                    count+=c1;
                }
                else{
                    int temp=s2;
                    while(temp<j){
                        char swap = str[temp];
                        str[temp] = str[temp+1];
                        str[temp+1] = swap;
                        temp++;
                    }
                    count+=c2;
                }             
            }
            i++;
            j--;
        }

        return count;
    }
}