class Solution {
    public boolean isAnagram(String s, String t) {
    Map<Character,Integer> maps = new HashMap<>();
    Map<Character,Integer> mapt = new HashMap<>();
    
for (char c : s.toCharArray()) {
    maps.put(c, maps.getOrDefault(c, 0) + 1);
}
for (char c : t.toCharArray()) {
    mapt.put(c, mapt.getOrDefault(c, 0) + 1);
}
return maps.equals(mapt);
    }
    

}