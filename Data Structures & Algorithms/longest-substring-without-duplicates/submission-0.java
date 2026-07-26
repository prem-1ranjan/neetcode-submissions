class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max =0;
        int slow = 0;
        for(int fast =0;fast<s.length();fast++){
       while(set.contains(s.charAt(fast))){
        set.remove(s.charAt(slow));
        slow++;
       }
       set.add(s.charAt(fast));
       max = Math.max(max,set.size());
        }
        return max;
    }
}
