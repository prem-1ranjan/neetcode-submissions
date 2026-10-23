// class Solution {
//     public String minWindow(String s, String t) {
//         if (s.length() < t.length()) return "";

//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         int required = map.size();   // distinct chars needed with full count
//         int formed = 0;              // distinct chars currently satisfied

//         HashMap<Character, Integer> windowCounts = new HashMap<>();

//         int l = 0, r = 0;
//         int minLength = Integer.MAX_VALUE;
//         int sidx = -1;

//         while (r < s.length()) {
//             char c = s.charAt(r);
//             windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

//             if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
//                 formed++;
//             }

//             // window valid hone par shrink karo
//             while (l <= r && formed == required) {
//                 if (r - l + 1 < minLength) {
//                     minLength = r - l + 1;
//                     sidx = l;
//                 }

//                 char leftChar = s.charAt(l);
//                 windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
//                 if (map.containsKey(leftChar) && windowCounts.get(leftChar) < map.get(leftChar)) {
//                     formed--;
//                 }
//                 l++;
//             }

//             r++;
//         }

//         return sidx == -1 ? "" : s.substring(sidx, sidx + minLength);
//     }
// }




class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int l = 0, r = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = 0;

        while (r < s.length()) {
            if (map[s.charAt(r++)]-- > 0) {
                count++;
            }
            while (count == t.length()) {
                if (r - l < minLen) {
                    minLeft = l;
                    minLen = r - l;
                }
                if (map[s.charAt(l++)]++ == 0) {
                    count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}