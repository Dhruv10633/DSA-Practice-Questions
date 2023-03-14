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

bool is_poss(vector<vector<int>> board,int n,int i,int j,int val){
    //vertical check
    for(int k=0 ; k<n; k++){
        if(board[k][j]==val){          
            return false;            
        }
    }

    //horizontal check
    for(int k=0  ; k<n; k++){
        if(board[i][k]==val){          
            return false;            
        }
    }

    //sub matrix check

    int boxi=i-i%3;   // helps decide the coordinates of the start of the mini matrix in which we are placing the val
    int boxj=j-j%3;   //

    for(int k=0;k<3;k++){
        for(int l=0;l<3;l++){
            if(board[boxi+k][boxj+l]==val){
                return false;
            }
        }
    }

    
    return true;                      //no same number present in the sub matrix and vertically and horizontally

}

bool sudoku_solver_recurs(vector<vector<int>> board,int n,int i,int j){
    if(i==n){
        print_board(board,n);
        return true;   // if we just need 1 possibility 
        // return false;  // if we just need all possibilities
    }

        if(j==n){
            return sudoku_solver_recurs(board,n,i+1,0);  //return not necessary here though u can use if u want
        }
        
        if(board[i][j]==0){                                    //if the sudoku space is empty
            for(int val=1;val<=n;val++){
                
                if(is_poss(board,n,i,j,val)){
                    
                    board[i][j]=val;
                    if(sudoku_solver_recurs(board,n,i,j+1)){  // it goes and checks on the "next" column pos if we can enter a valid sudoku num
                        return true;  // this happens when the entire sudoku has been solved
                    }
                    
                    board[i][j]=0;   //backtrack the number at "curr_pos" if the numbers we inputed earlier in sudoku are wrong and need to go back
                
                    
                }
                
            }
            return false; 
        }
        return sudoku_solver_recurs(board,n,i,j+1);  //no else cause we need to go to next col 
                                              //whether there is 0 or not
}

// iterative is possible here  cause once we cross a row in sudoku we dont need togo back
// to that row
bool sudoku_solver_iterative(vector<vector<int>> &board,int n){
    for (int i=0; i < n; i++) {
        for (int j=0; j < n; j++) {
            if (board[i][j] == 0) {
                for (int num=0; num<=n; num++) {
                    if (is_poss(board,n, i, j, num)) {
                        board[i][j] = num;

                        if (sudoku_solver_iterative(board,n))
                            return true;
                        else
                            board[i][j] = 0;
                    }
                }
                return false;
            }
        }
    }
    print_board(board,n);
    return false;  //false for multiple
}

int main(){

    vector<vector<int>> board = {
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //   {0, 0, 0, 0, 0, 0, 0, 0, 0}
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 4, 0, 0, 2, 6, 0},
      {2, 0, 8, 0, 0, 0, 9, 0, 4},
      {0, 0, 0, 0, 0, 1, 5, 3, 2},
      {0, 2, 3, 9, 0, 0, 1, 0, 0},
      {0, 1, 0, 3, 2, 4, 0, 0, 0},
      {8, 4, 5, 0, 0, 0, 0, 0, 9},
      {0, 7, 0, 1, 9, 5, 0, 0, 0},
      {0, 0, 0, 0, 4, 6, 0, 5, 3}
    };
    
    // sudoku_solver_recurs(board,9,0,0);
    sudoku_solver_iterative(board,9);
    
    
}