// https://www.codechef.com/submit/J3

// Safely put N- Queens on NxN chess board
// Note: We can put max N queens on board

#include<bits/stdc++.h>
using namespace std;

void print_board(vector<vector<int>> board,int n){
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout << board[i][j]<< " ";
        }cout << endl;
    }cout << endl;
}

bool is_safe(vector<vector<int>> board,int n,int i,int j){
    //horizontal check
    for(int k=j-1;k>=0;k--){
        if(board[i][k]==1){
            return false;
        }
        else if(board[i][k]==8){
            break;
        }
    }

    //upper diagonal check       
    for(int k=i-1, l=j-1  ; k>=0 && l>=0; k--,l--){
        if(board[k][l]==1){
            return false;            
        }
        else if(board[k][l]==8){
            break;            
        }
    }
    //lower Diagonal Check
    for(int k=i+1, l=j-1  ; k<n && l>=0; k++,l--){
        if(board[k][l]==1){
            return false;        
               
        }
        else if(board[k][l]==8){
            break;            
        }
    }
    return true;                      //because the queen is safe both diagonally and vertically and hence can be kept

}

bool n_Queens(vector<vector<int>> board,int n, int i, int j){
    //i loop
    if(j==n){
        print_board(board,n);
        return false;
        //return true;
    }

        //j loop  
        if(i==n){
            return false;        // this false goes to 71 line
        }
            if(board[i][j]==0){ 
                if(is_safe(board,n,i,j)){
                    board[i][j]=1;
                    if(n_Queens(board,n,0,j+1)){  // if we found queen in next col
                        return true;
                    }
                    board[i][j]=0;                //else backtrack the earlier step                  
                }
            }
            return n_Queens(board,n,i+1,j);          //to go to the next row if we

        // // Basically u can use for loop for row /col when u want to place only 1 thing per row/col
        // // like here 1 Queen per col but no such limitation in row 
        // iterative loop
        // for(int k=0;k<n;k++){
        //     if(board[k][j]==0){
        //         if(is_safe(board,n,k,j)){
        //             board[k][j]=1;
        //             if(n_Queens(board,n,0,j+1)){  // if we found queen in next col
        //                 return true;
        //             }
        //             else{                         //else backtrack the earlier step
        //                 board[k][j]=0;
        //             }
        //         }
        //     }
        // }

    return false;    

}

int main(){
    int n;
    cin>>n;

    vector<vector<int>> board(n,vector<int>(n,0));    //*imp

    int k;
    cin>>k;

    while(k--){
        int i,j;
        cin>>i>>j;
        board[i-1][j-1]=8;   //blocked spaces
    }


    n_Queens(board,n,0,0);
    
}

