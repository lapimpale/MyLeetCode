class Solution {
    public int trap(int[] height) {
       int maxLeft = 0;
        int maxRight = 0;
        int totalArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {

           

            if (height[leftPointer] <= height[rightPointer]) {

        

                if (maxLeft > height[leftPointer]) {
             
                    totalArea += maxLeft - height[leftPointer];

                } else {
                    maxLeft = height[leftPointer];

                }
                leftPointer++;
            } else {
              
                //the rightPointer value is less than the leftPointer value hence operate on the right side of the array.
                if (maxRight > height[rightPointer]) {
                
                    totalArea +=  maxRight - height[rightPointer];

                } else {
                    maxRight = height[rightPointer];
                }

                rightPointer--;

            }


        }

        return totalArea; 
    }
}