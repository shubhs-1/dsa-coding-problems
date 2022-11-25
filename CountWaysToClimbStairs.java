//A person can make jumps of only 1,2,3,4,5 meters at a time.
// Identify a number of ways to cover the exact N meter.

// GFG - https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/

public class CountWaysToClimbStairs {
    public static void main(String[] args) {
        int nStairs = 35;

        // usign recursion
        long start = System.currentTimeMillis();
        System.out.println(countWaysUsingRecursion(nStairs));
        long end = System.currentTimeMillis();
        System.out.println("[Recursion] Time taken : " + (end - start) + " ms");

        // using DP
        long startDP = System.currentTimeMillis();
        System.out.println(countWaysUsingDynamicProgramming(nStairs));
        long endDP = System.currentTimeMillis();
        System.out.println("[DP] Time taken : " + (endDP - startDP) + " ms");
    }

    public static long countWaysUsingRecursion(int nStairs) {
        if(nStairs < 0) {
            return 0;
        }
        if(nStairs == 0) {
            return 1;
        }

        return countWaysUsingRecursion(nStairs - 1) +
                    countWaysUsingRecursion(nStairs - 2) +
                        countWaysUsingRecursion(nStairs - 3);
    }

    public static long countWaysUsingDynamicProgramming(int nStairs) {
        long dp[] = new long[nStairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=nStairs; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[nStairs];
    }
}
