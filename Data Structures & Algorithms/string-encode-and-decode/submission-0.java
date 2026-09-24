class Solution {

    public String encode(List<String> strs) {
        StringBuffer encode_string = new StringBuffer();
        for(String s : strs){
            encode_string.append(s.length()).append('#').append(s);

        }
        return encode_string.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
        int j = i;
        while(str.charAt(j) !='#') {
            j++;
        }
        int w_len = Integer.parseInt(str.substring(i,j));
        String word = str.substring(j+1,j+1+w_len);
        res.add(word);
        i=j+1+w_len;
        }
        return res;
    }
}
