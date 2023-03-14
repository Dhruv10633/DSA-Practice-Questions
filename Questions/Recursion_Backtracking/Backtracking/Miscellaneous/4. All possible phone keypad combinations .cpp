// https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1

#include <bits/stdc++.h>
#include <string>

using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    //Function to find list of all words possible by pressing given numbers.
    
    void combinations(int a[], int n ,vector<string> numpad,int index ,string comb,vector<string> &ans){
        if(index==n){
            ans.push_back(comb);
            return;
        }
        
        int num=a[index];
        for(int i=0;i<numpad[num].size();i++){
            comb+=numpad[num][i];
            combinations(a,n ,numpad,index+1,comb,ans);
            comb.pop_back();
        }
        return;
    }
    
    vector<string> possibleWords(int a[], int n)
    {
        vector<string> numpad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        vector<string> ans;
        
        combinations(a,n ,numpad,0,"",ans);
        return ans;
    }
};


//{ Driver Code Starts.

int main() {
  
	int T;
	
	cin >> T; //testcases
	
	while(T--){ //while testcases exist
	   int N;
	    
	   cin >> N; //input size of array
	   
	   int a[N]; //declare the array
	   
	   for(int i =0;i<N;i++){
	       cin >> a[i]; //input the elements of array that are keys to be pressed
	   }
	   
	   Solution obj;
	   
	  vector <string> res = obj.possibleWords(a,N);
	  for (string i : res) cout << i << " ";
	   cout << endl;
	}
	
	return 0;
}
// } Driver Code Ends