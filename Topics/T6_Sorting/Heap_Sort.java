//https://leetcode.com/problems/sort-an-array/description/
package Topics.T6_Sorting;

class Solution {
    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    private int[] heapSort(int arr[]){
        int n=arr.length;

        //Creating MaxHeap
        //n/2-1 is the last parent node in the bin heap
        for(int i = n/2 - 1 ; i>=0 ; i--){
            heapify(arr,i,n);
        }

        //Removing element from top of heap and again creating a max heap from remaining ele
        for(int i=n-1 ; i>0 ;i--){
            //swapping the largest ele to the end
            int swap=arr[0];
            arr[0]=arr[i];
            arr[i]=swap;

            //creating a max heap of the remaining elements
            //checking heap till i th pos
            heapify(arr,0,i);
        }

        return arr;
    }

    private void heapify(int arr[],int i,int n){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest=right;
        }

        //if there is a greater child
        if(largest!=i){
            //swap parent child
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr,largest,n);
        }
    }   
}
