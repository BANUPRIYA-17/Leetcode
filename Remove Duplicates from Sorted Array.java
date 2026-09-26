class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int uniqueIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;        
                nums[uniqueIndex] = nums[i]; 
            }
        }
        
        // The count of unique elements is the index + 1
        return uniqueIndex + 1;
    }
}
