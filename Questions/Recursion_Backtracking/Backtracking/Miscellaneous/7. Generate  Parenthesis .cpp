// https://hack.codingblocks.com/app/contests/3413/543/problem
#include <bits/stdc++.h>
using namespace std;

void balanced_parenthesis(int open,int close,string ans,vector<string> &vec){
    if(open==0 && close==0){
        vec.push_back(ans);
        return;
    }

    if(open>0){          // we can add '(' to string at any point
        ans+='(';
        balanced_parenthesis(open-1,close,ans,vec);
        ans.pop_back();  // backtrack
    }

    if(close>0 && close>open ){      // but here we can add ')' only if we have an extra '(' in string 
                         // eg "(()" ,we have an extra open in string so can add close in it.
                         // eg "()" if we add close here the string will be unbalanced 
        ans+=')';
        balanced_parenthesis(open,close-1,ans,vec);
        ans.pop_back();  // backtrack
    }
    return;
}

int main(){
    int n;
    cin>>n;

    
    vector<string> vec;
    balanced_parenthesis(n,n,"",vec);

    // sort(vec.begin(),vec.end());    // no need to sort
    for(int i=vec.size()-1 ;i>=0;i--){
        cout<<vec[i]<<endl;
    }
}