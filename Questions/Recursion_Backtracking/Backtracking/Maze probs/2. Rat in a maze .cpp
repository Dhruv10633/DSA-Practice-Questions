// Find the shortest path for a rat to reach the destination of a 6x6 maze. In this maze at some places 
// places "x" there is a cat so u need to skip those points in maze.Also the rat can move only right and down

//  START  O O O O O O 
//         O O O O O O 
//         O O O X O O 
//         O O O O O O 
//         O O X O O O 
//         O X O O O O  DESTINATION

//EVERY PATH IS SHORTEST AS LONG AS WE MOVE RIGHT OR DOWN.

#include<bits/stdc++.h>
using namespace std;

void print_maze(vector<vector<char>> arr,int m,int n){
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout << arr[i][j]<< " ";
        }cout << endl;
    }cout << endl;
}

int cnt=0;                           // total number of possible solutions
// if we need all solutions and not just 1 correct path we can use void type return instead of bool.
// As the void type functin doesnt care about whether we found the correct solution in base condition it will check for
// all possible solutions.
bool rat_in_maze(vector<vector<char>> arr,int m,int n,int i,int j){
    //base cond
    if(j==n-1 && i==m-1){  //destination
        arr[i][j]='1';
        cnt++;
        print_maze(arr,m,n);
        // return                   // for void type function
        return false;               //true prints only 1 solution
                                    //false prints all the solutions
    }

    //recursive case
    if(arr[i][j]=='O'){
        arr[i][j]='1';
        if(j+1<n && arr[i][j+1]=='O'){
            if (rat_in_maze(arr,m,n,i,j+1)){     //do not return false cause we need only the path that has a valid solution
                // cnt++;
                return true;                  
            }
            // rat_in_maze(arr,m,n,i,j+1)      // for void type func
        }

        if(i+1<m && arr[i+1][j]=='O'){               // not "else if" cause if we go right once it totally ignores the down step
            if (rat_in_maze(arr,m,n,i+1,j)){     //do not return false
                // cnt++;
                return true;
            } 
            // rat_in_maze(arr,m,n,i+1,j)      // for void type function
        }
        arr[i][j]='O';                          //backtracking step
        return false;   
    }
    return false;          //imp in case no solution possible


}

int main(){
    int n,m;
    cin>>m>>n;

    vector<vector<char>> arr(m,vector<char>(n));

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cin>>arr[i][j];
        }
    }
    
    rat_in_maze(arr,m,n,0,0);
    cout<<cnt;
  
}