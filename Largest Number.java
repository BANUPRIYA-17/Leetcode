import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert to String array
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);

        // 2. Sort using the "Pair Test"
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        // 3. Handle edge case: if the biggest number is "0", the result is "0"
        if (s[0].equals("0")) return "0";

        // 4. Join them together
        StringBuilder sb = new StringBuilder();
        for (String str : s) sb.append(str);
        
        return sb.toString();
    }
}
