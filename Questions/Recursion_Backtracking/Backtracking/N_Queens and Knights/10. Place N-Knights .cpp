// https://hack.codingblocks.com/app/contests/3413/265/problem

#include<bits/stdc++.h>
using namespace std;

void print_pos(vector<vector<int>> &board,int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]==1)cout<<"{"<<i<<"-"<<j<<"} ";
        }
    }cout<<" ";
    cout<<endl;
    
}

bool is_valid(vector<vector<int>> &board,int n,int i,int j){
    if(i-1>=0){
        if(j-2>=0){
            if(board[i-1][j-2]==1){
                return false;
            }
        }
        if(j+2<n){
            if(board[i-1][j+2]==1){
                return false;
            }
        }
    }
    if(i-2>=0){
        if(j+1<n){
            if(board[i-2][j+1]==1){
                return false;
            }
        }
        if(j-1>=0){
            if(board[i-2][j-1]==1){
                return false;
            }
        }
        
    }
    return true; 
}

// Basically u can use for loop for row /col when u want to place only 1 thing per row/col
// here no such limitaion on either row/col so cannot use for loop here
bool N_Knights(vector<vector<int>> &board,int n ,int i ,int j,int knight ,int &cnt){
    //base cond
    if(knight==n){
        cnt++;
        print_pos(board,n);
        return false;
    }
    
        //recursive cond
        if(i==n ){
            return false;
        }
            // return the next i when j==n and not false cause we have no cond here stating that at least one knight per row/col
            if(j==n){
                return N_Knights(board,n,i+1,0,knight,cnt);
            }
                if(is_valid(board,n,i,j)){
                    knight++;
                    board[i][j]=1;
                    if(N_Knights(board,n,i,j+1,knight,cnt)){       
                        return true;
                    }
                    knight--;
                    board[i][j]=0;
                    
                }

                return N_Knights(board,n,i,j+1,knight,cnt);
            
            // return false;       
}

int main(){
    int n;
    cin>>n;

    vector<vector<int>> board(n,vector<int>(n,0));
    int cnt=0;
    // int knight=n;
    N_Knights(board,n,0,0,0,cnt);
    cout<<endl<<cnt;
    
}