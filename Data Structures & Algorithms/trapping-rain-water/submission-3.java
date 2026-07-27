class Solution {
    public int trap(int[] height) {
        int l = 0; int r =height.length-1;
        int leftmax = 0, rightmax =0;int totalwater = 0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=leftmax){
                     leftmax = height[l];
                        } else {
                    totalwater += leftmax - height[l];
                }
                       l++;     
                }
                
            
            else{
                 if(height[r]>=rightmax){
                    rightmax = height[r];
                    totalwater += rightmax - height[r];
                       
                 } else {
                    totalwater += rightmax - height[r];
                }
                r--;
            }
         
        }
       return totalwater;
    }
}
