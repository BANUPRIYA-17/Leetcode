class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;

        int k = primes.length;
        int[] dp = new int[n];
        int[] pointers = new int[k]; 
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            
       
            for (int j = 0; j < k; j++) {
                long nextVal = (long) dp[pointers[j]] * primes[j];
                min = Math.min(min, nextVal);
            }

            dp[i] = (int) min;

            
            for (int j = 0; j < k; j++) {
                if (min == (long) dp[pointers[j]] * primes[j]) {
                    pointers[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}
