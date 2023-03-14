// https://hack.codingblocks.com/app/contests/3413/447

#include<bits/stdc++.h>
using namespace std;


int Mazepath_D2(int n,int i, int j,string path,int &cnt){
    if(i==n-1 && j==n-1){
        cnt++;
        cout<<path<<" ";
        
        return 1;                                   //returns 1 if it founds end of path i.e. 1 path found
    }

    if(i+1<n){
        // path.push_back('H');
        Mazepath_D2(n,i+1,j,path+'V',cnt);     //Always use this type o
        // path.pop_back();                         //backtracking if we use push_back in string
    }
    if(j+1<n){
        // path.push_back('H');
        Mazepath_D2(n,i,j+1,path+'H',cnt);
        // path.pop_back();
    }
    if((i+1<n && j+1<n) && ((i==j)||(i+j==n-1)) ){
            // path.push_back('D');
            Mazepath_D2(n,i+1,j+1,path+'D',cnt);
            // path.pop_back();
    }
    return 0;

}


int main() {
    int n;
    cin>>n;

    // vector<vector<int>> maze(m,vector<int>(n));  //no need for vector or 2d
    int cnt=0;
    Mazepath_D2(n,0,0,"",cnt);
    cout<<endl<<cnt;
	
}