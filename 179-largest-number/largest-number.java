class Solution {
    public String largestNumber(int[] nums) {

        // Convert int array to String array
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort according to which concatenation gives a larger number
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest element is "0", then all elements are 0
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the answer
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}