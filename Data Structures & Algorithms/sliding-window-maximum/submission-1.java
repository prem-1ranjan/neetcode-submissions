// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int[] result  = new int[nums.length];
//         int s=0;
        
//         for(int i = s;i<=k+s;i++){
//             int max = 0;
//             max = Math.max(max,nums[i]);
//             result[i] = max;
//         }
//         s++;
        
//     }
// }




class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        
        // Deque will store indices of array elements
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // 2. Remove indices of smaller elements from the back
            // They are useless because the current element is larger and arrived later
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add the current element's index to the back
            deque.offerLast(i);
            
            // 4. If we have hit the window size 'k', add the max to the result
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}