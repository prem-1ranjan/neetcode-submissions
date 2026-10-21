// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> set = new HashSet<>();
//         int max =0;
//         int slow = 0;
//         for(int fast =0;fast<s.length();fast++){
//        while(set.contains(s.charAt(fast))){
//         set.remove(s.charAt(slow));
//         slow++;
//        }
//        set.add(s.charAt(fast));
//        max = Math.max(max,set.size());
//         }
//         return max;
//     }
// }
// ============================================================
class Solution {
    public int lengthOfLongestSubstring(String s) {
Set<Character> set = new HashSet<>();
int i = 0; int j= 0;int max = 0;
while(j<s.length()){
    while(set.contains(s.charAt(j))){
        set.remove(s.charAt(i));
        i++;
        
    }
        set.add(s.charAt(j));
    
     max = Math.max(max,j-i+1);
    j++;
   
}
return max;
}

}















