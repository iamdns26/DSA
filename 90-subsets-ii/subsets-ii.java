class Solution {
    public void helper(int[] arr, int idx, List<Integer> out, Set<List<Integer>> set) {
        if (idx == arr.length) {
            set.add(new ArrayList<>(out));  
            return;
        }

        
        List<Integer> list1 = new ArrayList<>(out); // skip
        
        List<Integer> list2 = new ArrayList<>(out); // take
        list2.add(arr[idx]);

        helper(arr, idx + 1, list1, set);
        helper(arr, idx + 1, list2, set);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }
}
