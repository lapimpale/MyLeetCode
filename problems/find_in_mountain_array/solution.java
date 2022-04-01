/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
public int findInMountainArray(int target, MountainArray ar) {
int n=ar.length();
int start=1;
int end=n-2;
int peakIndex=0;

    while(end>=start){
        int mid=start+(end-start)/2;
        
        
        int midVal=ar.get(mid);
        int prevVal=ar.get(mid-1);
        int nextVal=ar.get(mid+1);
        
        
        if(midVal>prevVal && midVal>nextVal){
            peakIndex=mid;
            if(midVal==target){
                return peakIndex;
            }
            break;
        }
        else if(nextVal<midVal){
            end=mid-1;

        }
        else {
            start=mid+1;
        }
    }
    
    
    
    start=0;
    end=peakIndex-1;
    while(start<=end){
        int mid=start+(end-start)/2;
        int midVal=ar.get(mid);
        if(midVal==target){
            return mid;
        }
        if(midVal<target){
            start=mid+1;
        }else{
            end=mid-1;
        }
    } 
    
    start=peakIndex+1;
    end=n-1;
    while(start<=end){
        int mid=start+(end-start)/2;
        int midVal=ar.get(mid);
        if(midVal==target){
            return mid;
        }
        if(midVal>target){
            start=mid+1;
        }else{
            end=mid-1;
        }
    } 
    
    return -1;
    

    
    
}
}