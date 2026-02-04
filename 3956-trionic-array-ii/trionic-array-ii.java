class Solution {
    public long maxSumTrionic(int[] nums) {
        
        int n = nums.length;
        // Initialize res with a very small number, as sums can be negative
        long res = -1 * (long)1e16; 

        // Iterate through possible starting points for the middle decreasing part
        // i must be at least 1 (for left part) and at most n-3 (for right part)
        for(int i = 1; i < n - 2; i++){

            int a = i; 
            int b = i; 

            long net = nums[a]; // Sum for the middle decreasing part

            // Find the middle decreasing part (nums[b+1] < nums[b])
            while(b + 1 < n && nums[b + 1] < nums[b]){
                net += (long)nums[b + 1];
                b++;
            }

            // If the middle part didn't decrease (length < 2), it's not a valid valley
            if(b == a) continue; 

            int c = b; // 'c' marks the end of the decreasing part

            long left = 0;
            long right = 0;

            // Initialize lx and rx with a very small number (Long.MIN_VALUE) for max prefix sums
            long lx = Long.MIN_VALUE; 
            long rx = Long.MIN_VALUE;

            // Find the left increasing part (nums[a-1] < nums[a])
            // 'a' starts at 'i' and moves left
            int originalA = a; // Store original 'a' (which is 'i') for condition check
            while(a - 1 >= 0 && nums[a - 1] < nums[a]){
                left += (long)nums[a - 1];
                lx = Math.max(lx, left); // Keep track of max prefix sum
                a--;
            }

            // If the left part didn't increase (length < 2), it's not a valid hill
            if(a == originalA) continue; 

            // Find the right increasing part (nums[b+1] > nums[b])
            // 'b' starts at 'c' and moves right
            int originalB = b; // Store original 'b' (which is 'c') for condition check
            while(b + 1 < n && nums[b + 1] > nums[b]){
                right += (long)nums[b + 1];
                rx = Math.max(rx, right); // Keep track of max prefix sum
                b++;
            }

            // If the right part didn't increase (length < 2), it's not a valid hill
            if(b == originalB) continue; 
            
            // Optimization: Jump 'i' to the end of the processed segment
            // This prevents re-processing elements and ensures O(N) complexity
            i = b - 1; 
            res = Math.max( res, lx + rx + net);
        }
        return res;
    }
}