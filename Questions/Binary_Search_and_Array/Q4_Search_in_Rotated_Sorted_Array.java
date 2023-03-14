package Binary_Search_and_Array;
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
import java.util.*;

public class Q4_Search_in_Rotated_Sorted_Array {
    
    public static int search(int[] arr, int target) {
        int l=0;
        int h=arr.length-1;

        while(l<=h){
            int mid=(l+h)/2;

            if(arr[mid]==target){
                return mid;
            }

            //checking if 1st part of arr is in ascending order
            else if(arr[l]<=arr[mid]){
                if(target >= arr[l] && target<arr[mid]){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }

            //checking if the mid to high part in ascending
            else if(arr[mid]<=arr[h]){
                if(target>arr[mid] && target<=arr[h]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}
