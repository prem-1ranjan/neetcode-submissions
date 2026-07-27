class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = map.size();   // distinct chars needed with full count
        int formed = 0;              // distinct chars currently satisfied

        HashMap<Character, Integer> windowCounts = new HashMap<>();

        int l = 0, r = 0;
        int minLength = Integer.MAX_VALUE;
        int sidx = -1;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // window valid hone par shrink karo
            while (l <= r && formed == required) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    sidx = l;
                }

                char leftChar = s.charAt(l);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (map.containsKey(leftChar) && windowCounts.get(leftChar) < map.get(leftChar)) {
                    formed--;
                }
                l++;
            }

            r++;
        }

        return sidx == -1 ? "" : s.substring(sidx, sidx + minLength);
    }
}