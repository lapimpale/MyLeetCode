class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
    
        while(start<end){
            int h = Math.min(height[start],height[end]);
            int w = end - start;
            
            if(area < h*w){
                area = h*w;
            }
            
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return area;
    }
}