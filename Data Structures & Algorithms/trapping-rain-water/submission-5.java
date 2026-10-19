// class Solution {
//     public int trap(int[] height) {
//      int n  = height.length;
//      int []maxpre = new int[n];
//      int []maxsuff = new int[n];
//      maxpre[0] = height[0];
//      maxsuff[n-1] = height[n-1];
//      for(int i = 1;i<n;i++){
//         maxpre[i] = Math.max(maxpre[i-1],height[i]);
//      } 
//      for( int i = n-2;i>=0;i--){
//         maxsuff[i] = Math.max(maxsuff[i+1],height[i]);
//      }
//      int water = 0;
//      for(int i =0 ;i<n;i++){
//         water += Math.min(maxpre[i],maxsuff[i])-height[i];
//      }
//      return water;
        
//     }
// }



class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int l = 0; 
        int r = height.length - 1;
        int leftMax = 0; 
        int rightMax = 0;
        int totalWater = 0;
        
        while (l < r) {
            // We process the smaller height because it acts as the bottleneck
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l]; // Update left max
                } else {
                    totalWater += leftMax - height[l]; // Water trapped
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r]; // Update right max
                } else {
                    totalWater += rightMax - height[r]; // Water trapped
                }
                r--;
            }
        }
        
        return totalWater;
    }
}