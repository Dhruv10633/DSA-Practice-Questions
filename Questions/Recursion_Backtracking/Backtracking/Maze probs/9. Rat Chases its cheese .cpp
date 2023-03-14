// https://hack.codingblocks.com/app/contests/3413/535

#include<bits/stdc++.h>
using namespace std;

//We cannot use iterative here cause we are going up,down,left and right
bool rat_in_maze(vector<vector<char>> &arr,int m,int n,int i,int j){
    //base cond
    if(j==n-1 && i==m-1){  //destination
        arr[i][j]='1';

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]=='1')cout << 1<< " ";
				else cout << 0<< " ";
			}cout << endl;
		}cout << endl;

        return true;               
                                    
    }

    //recursive case
	//We do not need j loop condition here cause the below part does that job
	if(arr[i][j]=='O'){

		arr[i][j]='1';

		//Go right
		if(j+1<n && arr[i][j+1]=='O'){
			if (rat_in_maze(arr,m,n,i,j+1)){     
				return true;                  
			}
		}

		//Go left
		if(j-1>=0 && arr[i][j-1]=='O'){
			if (rat_in_maze(arr,m,n,i,j-1)){     
				return true;                  
			}
		}

		//Go down
		if(i+1<m && arr[i+1][j]=='O'){               
			if (rat_in_maze(arr,m,n,i+1,j)){ 
				return true;
			} 
		}

		//Go up
		if(i-1>=0 && arr[i-1][j]=='O'){               
			if (rat_in_maze(arr,m,n,i-1,j)){ 
				return true;
			} 
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
    
    if(!rat_in_maze(arr,m,n,0,0)){
		cout<<"NO PATH FOUND";
	}
  
}