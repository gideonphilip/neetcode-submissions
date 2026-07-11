class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minValue = prices[0];
        int maxProfit = 0;

        for(int i=1; i<n; i++){
            int profit = prices[i] - minValue;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            if(prices[i]<minValue){
                minValue = prices[i];
            }
        }
        return maxProfit;
    }
}
