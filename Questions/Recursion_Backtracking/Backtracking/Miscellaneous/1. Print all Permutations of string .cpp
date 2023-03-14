#include<bits/stdc++.h>
using namespace std;

//This works only for strings which "pass by value"

void permutaions(string s,int i){
	//base cond
	if(i==s.size()){
		cout<<s<<endl;
        return;
	}

    //recurse cond
    for(int j=i;j<s.size();j++){
        swap(s[i],s[j]);
        permutaions(s,i+1);
    }
}

//In case we take a char array then we need to do backtracking step caue the 
//ans will only be correct if we do the loop operation on the original char array or string 
//and without the backtracking step here the char array would be changed and the operations on the changed array will not give corrext solns.

//In the above function if we send string reference then we have to write the backtracking step there too 
bool permutaions(char s[],int i,int n){
	//base cond
	if(i==n){
		cout<<s<<endl;
        return false;  // false to get all permutaions
	}

    //recurse cond
    for(int j=i;j<n;j++){
        swap(s[i],s[j]);
        if(permutaions(s,i+1,n)){
            return true;
        }
        swap(s[i],s[j]);       //backtracking step
    }
    return false;
}

int main(){
    // string s;
    // cin>>s;

    int n;
    cin>>n;
    char s[n];
    for(int i=0;i<n;i++){
        cin>>s[i];
    }

    permutaions(s,0,n);
    
}