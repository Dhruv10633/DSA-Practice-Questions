//
package Binary_Search_and_Array;

class Solution {
    public int search(int[] arr, int targ) {
        int l=0, h=arr.length-1;

		while(l<=h){
			int mid = l+(h-l)/2;

			if(arr[mid]==targ){
				return mid;
			}

			else{
                //check this subarr in ascend
				if(arr[mid]<=arr[h]){
					if(targ<=arr[h] && arr[mid]<targ){
						l=mid+1;
					}
					else{
						h=mid-1;
					}
				}

                //check this subarr in ascend
                else if(arr[mid]>=arr[l]){
					if(targ>=arr[l] && targ<arr[mid]){
						h=mid-1;
					}
					else{
						l=mid+1;
					}
				}
			}
		}
		return -1;
    }
}
