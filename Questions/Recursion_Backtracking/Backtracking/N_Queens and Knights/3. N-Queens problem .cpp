// Safely put N Queens on NxN chess board
// Note: We can put max N queens on board

#include<bits/stdc++.h>
using namespace std;

void print_board(vector<vector<int>>&board,int m,int n){
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout << board[i][j]<< " ";
        }cout << endl;
    }cout << endl;
}

bool is_safe(vector<vector<int>>&board,int m,int n,int i,int j){
    //vertical check
    for(int k=0;k<i;k++){
        if(board[k][j]==1){          // 1 i.e another queen found 
            return false;            //we use false instead of break  as we do not need to check all other for loops
        }
    }

    //Left upper diagonal check       //we have 0 queens below this row at this time so no downward diagnol check
    for(int k=i-1, l=j-1  ; k>=0 && l>=0; k--,l--){
        if(board[k][l]==1){
            return false;            
        }
    }
    //Right upper Diagonal Check
    for(int k=i-1, l=j+1  ; k>=0 && l<n; k--,l++){
        if(board[k][l]==1){
            return false;            
        }
    }
    return true;                      //because the queen is safe both diagonally and vertically and hence can be kept

}

bool n_Queens_recurs(vector<vector<int>> &board,int m,int n,int i){
    if(i==m){
        print_board(board,m,n);
        // return true;   // if we just need 1 possibility of keeping n queens
        return false;  // if we just need all possibility of keeping n queens
    }

    for(int j=0;j<n;j++){
        if(is_safe(board,m,n,i,j)){    //if true
            board[i][j]=1;             //we can keep the queen here
            if(n_Queens_recurs(board,m,n,i+1)){      //check if we can place a queen in the next line
                return true;
            }
            board[i][j]=0;             // backtracking step, if we cannot place a queen at the next line
                                            
        }
    }
    return false;
}

//not working
// bool n_Queens_iterative(vector<vector<int>> &board,int m,int n){
//     for(int i=0;i<m;i++){
//         for(int j=0;j<n;j++){
//             if(is_safe(board,m,n,i,j)){    //if true
//                 board[i][j]=1;             //we can keep the queen here
//                 if(n_Queens_iterative(board,m,n)){      //check if we can place a queen in the next line
//                     return true;
//                 }
//                 board[i][j]=0;             // backtracking step, if we cannot place a queen at the next line
//                                                
//             }
//         }
//         // return false;
//     }
//     print_board(board,m,n);
//     return true;
// }

int main(){
    int n,m;
    cin>>m>>n;

    vector<vector<int>> board(m,vector<int>(n,0));    //*imp

    n_Queens_recurs(board,m,n,0);
    // n_Queens_iterative(board,m,n);       //not working
    
}