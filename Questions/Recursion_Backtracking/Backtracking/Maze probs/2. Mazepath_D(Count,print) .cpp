// https://hack.codingblocks.com/app/contests/3413/234/problem
#include<bits/stdc++.h>
using namespace std;


int Mazepath_D(int m,int n,int i, int j,string path,int &cnt){
    if(i==m-1 && j==n-1){
        cnt++;
        cout<<path<<" ";
        
        return 1;                                   //returns 1 if it founds end of path i.e. 1 path found
    }

    if(i+1<m){
        // path.push_back('H');
        Mazepath_D(m,n,i+1,j,path+'V',cnt);     //Always use this type o
        // path.pop_back();                         //backtracking if we use pus_ back in string
    }
    if(j+1<n){
        // path.push_back('H');
        Mazepath_D(m,n,i,j+1,path+'H',cnt);
        // path.pop_back();
    }
    if(i+1<m && j+1<<n){
        // path.push_back('D');
        Mazepath_D(m,n,i+1,j+1,path+'D',cnt);
        // path.pop_back();
    }
    return 0;

}


int main() {
    int m,n;
    cin>>m;
    cin>>n;

    // vector<vector<int>> maze(m,vector<int>(n));  //no need for vector or 2d
    int cnt=0;
    Mazepath_D(m,n,0,0,"",cnt);
    cout<<endl<<cnt;
	
}