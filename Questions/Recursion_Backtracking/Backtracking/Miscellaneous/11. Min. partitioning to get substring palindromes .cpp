// https://www.youtube.com/watch?v=qmTtAbOTqcg

#include<bits/stdc++.h>
using namespace std;

int min_partitons_DP(string str){
    vector<vector<int>> dp(str.size(),vector<int>(str.size(),3));   // 0 means not a palindrome
                                                                // 1 means a paindrome
        // basic palindromic check matrix
        for(int s=1 ; s<= dp.size() ;s++){      // s signifies the size of substr 
            for(int i=0 ,j=s-1 ; j<dp.size() ;i++,j++){     // for j=s-1 check diagram
                
                // Trivial case :as string of size=1 are palindromes
                if(s==1){         // diagnol 1 with substr of size=1
                    dp[i][j]=1;   
                }

                // Trivial case :as string of size=2 so just check the start and end char
                else if(s==2){
                    if(str[i]==str[j]){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=0;
                    }
                }

                //This case can be ignored too as the else loop covers it too
                // Trivial case :as string of size=3 so just check the start and end char,
                // middle one doesn't matter
                else if(s==3){
                    if(str[i]==str[j]){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=0;
                    }
                }

                // Main case :now check the start and last char and if they both are equal,
                // then the previous diagnol element.
                // if true then palindrome, else false  eg
                // _ _ _ X
                // _ _ X _
                // _ _ _ _
                // _ _ _ _
            
                else{
                    if(str[i]==str[j]){
                        if(dp[i+1][j-1]==1){
                            dp[i][j]=1;   
                        }
                        else{
                            dp[i][j]=0;
                        }
                    }
                    else{
                        dp[i][j]=0;
                    }
                    
                }

            }
        }
        
        vector<vector<int>> ans(str.size(),vector<int>(str.size(),0));

        for(int s=1 ; s<= ans.size() ;s++){      // s signifies the size of substr 
            for(int i=0 ,j=s-1 ; j<ans.size() ;i++,j++){     // for j=s-1 check diagram
                
                if(s==1){         
                    ans[i][j]=0;     //because palindrome so no cut 
                }

                else if(s==2){
                    if(str[i]==str[j]){  //if palindrome so no cut  //or (dp[i][j]==1)
                        ans[i][j]=0;
                    }
                    else ans[i][j]=1;   // else 1 cut
                }
                else{
                    if(dp[i][j]==1){    // if palindrome  
                        ans[i][j]=0;    // 0 cut
                    } 
                    else{               // if not palindrome
                        int min_count=INT_MAX;
                        for(int k=i;k<j;k++){
                            int left =ans[i][k];
                            int right =ans[k+1][j];
                            min_count=min(min_count,left+right+1);      // partitions on the left side+right side and
                                                                    // +1 for the partition we did
                        }
                        ans[i][j]=min_count;
                    }
                }

            }
        }

        return ans[0][ans.size()-1];
}


bool is_palin(string s,int start,int n){
    if(s.empty()) return false;
    for(int i=start, j=n ;i<j;i++,j--){
        if(s[i]!=s[j]){
            return false;
        }
    }
    return true;
}
int min_partitions_recurs(string s,int i,int n,int ans){   
    if(i>=n || is_palin(s,i,n)){    //if either empty or palindrome then no need for any partition
        return 0;                    //hence we return 0
    }

        for(int k=i;k<n;k++){
            int count=min_partitions_recurs(s,i,k,ans) + 
                        min_partitions_recurs(s,k+1,n,ans)+1;
            ans=min(count,ans);
        }
    return ans;
}

int main(){
    int t=0;
    cin>>t;
    while(t--){
        string str;
        cin>>str;

        cout<<min_partitons_DP(str)<<endl;  
        // cout<<min_partitions_recurs(str,0,str.size()-1,str.size()-1)<<endl;

    }
    
    
}