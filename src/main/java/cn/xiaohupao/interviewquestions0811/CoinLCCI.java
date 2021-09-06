package cn.xiaohupao.interviewquestions0811;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/6 16:33
 */
public class CoinLCCI {

    public static int waysToChange(int n){
        //use dp
        //创建一个硬币种类的数组
        int[] coins = new int[]{1,5,10,25};

        //数组表示的含义是，以当前索引为值，共有多少种表示方法
        int[] dp = new int[n+1];
        dp[0] = 1;
        //遍历各种类型的硬币
        for (int coin : coins){
            for (int i = coin; i <= n; i++){
                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(10));
    }
}
