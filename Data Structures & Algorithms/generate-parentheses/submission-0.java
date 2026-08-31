class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuffer ans =new StringBuffer();
        List<String> res = new ArrayList<>();
        solve(n,0,0,ans,res);
        return res;
        
    }
    void solve(int n ,int open ,int close,StringBuffer ans,List<String> res){
        if(ans.length()==2*n){
            res.add(ans.toString());
            return;
        }
        if(close>open){
            return;
        }
        if(open<n){
        ans.append('(');
        solve(n,open+1,close,ans,res);
        ans.deleteCharAt(ans.length()-1);
        }
        if(close<n){
        ans.append(')');
        solve(n,open,close+1,ans,res);
        ans.deleteCharAt(ans.length()-1);
        }

    }
}
