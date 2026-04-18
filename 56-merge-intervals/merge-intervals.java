class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        int[] prev = arr[0];

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i][0] <= prev[1]){ // merge 
                prev[1] = Math.max(arr[i][1],prev[1]);
            }
            else{
                list.add(prev);
                prev = arr[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}