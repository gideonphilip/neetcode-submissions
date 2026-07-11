class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];
        return dfs(prices, 0, 0, memo);
    }

    static int dfs(int[] prices, int i, int holding, Integer[][] memo){
        if(i >= prices.length){
            return 0;
        }

        if(memo[i][holding] != null){
            return memo[i][holding];
        }
        int ans;
        if(holding == 1){
            ans = Math.max(
                prices[i] + dfs(prices, i+2, 0, memo),
                dfs(prices, i+1, 1, memo)
            );
        }else{
            ans = Math.max(
                -prices[i] + dfs(prices, i+1, 1, memo),
                dfs(prices, i + 1, 0, memo));
        }
        return memo[i][holding] = ans;
    }
}
