class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;

        while (l < r) {
            int width = r - l;
            int minHeight = Math.min(heights[l], heights[r]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}