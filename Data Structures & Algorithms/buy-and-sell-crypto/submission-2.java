class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        
        int maxProfit =0;
        while(buy<prices.length && sell<prices.length){
        if(prices[buy]>prices[sell]){
            buy = sell;
            sell++;
        }else{
           int profit =  prices[sell]-prices[buy];
           maxProfit =Math.max(maxProfit,profit);
           sell++;
        }
        }
        return maxProfit;
    }
}
