#include<bits/stdc++.h>
using namespace std;

bool is_palin(string s){
    if(s.empty()) return false;
    for(int i=0, j=s.size()-1 ;i<j;i++,j--){
        if(s[i]!=s[j]){
            return false;
        }
    }
    return true;
}


void palindromic_substrings(string s ,vector<vector<string>> &res ,vector<string> &palin_str){
    if(s.empty()){ 
        res.push_back(palin_str);
        return;
    }
        // // ALternate Method 1
        // for (int k=start; k<n; k++)
        // {
        //     // If substring str[start..k] is palindrome
        //     if (isPalindrome(str, start, k))
        //     {
        //         // Add the substring to result
        //         currPart.push_back(str.substr(start, k-start+1));
    
        //         // Recur for remaining substring
        //         allPalPartUtil(allPart, currPart, k+1, n, str);
                
        //         // Remove substring str[start..i] from current
        //         // partition
        //         currPart.pop_back();
        //     }
        // }


        for(int k=0;k<s.size();k++){
            // If substring temp[start ..k] is palindrome
            string temp=s.substr(0,k+1);
            if(is_palin(temp)){

                // Push that in vector
                palin_str.push_back(temp);

                // Recur for remaining substring
                palindromic_substrings(s.substr(k+1),res,palin_str);

                //backtracking step to Remove substring from the ans
                palin_str.pop_back();
            }
        }
    return;
}


int main(){
    string s;
    cin>>s;

    vector<vector<string>> res;
    vector<string> palin_str;

    palindromic_substrings(s,res,palin_str);
    for(int i=0;i<res.size();i++){
        for(int j=0;j<res[i].size();j++){
            cout<<res[i][j]<<" ";
        }cout<<endl;
    }
    
    
}