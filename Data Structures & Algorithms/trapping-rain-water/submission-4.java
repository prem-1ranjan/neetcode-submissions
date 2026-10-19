class Solution {
    public int trap(int[] height) {
     int n  = height.length;
     int []maxpre = new int[n];
     int []maxsuff = new int[n];
     maxpre[0] = height[0];
     maxsuff[n-1] = height[n-1];
     for(int i = 1;i<n;i++){
        maxpre[i] = Math.max(maxpre[i-1],height[i]);
     } 
     for( int i = n-2;i>=0;i--){
        maxsuff[i] = Math.max(maxsuff[i+1],height[i]);
     }
     int water = 0;
     for(int i =0 ;i<n;i++){
        water += Math.min(maxpre[i],maxsuff[i])-height[i];
     }
     return water;
        
    }
}
