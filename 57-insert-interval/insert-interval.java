class Solution {
    public int[][] insert(int[][] arr, int[] add) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0, n = arr.length;

        while(i < n && arr[i][1] < add[0]){ // handle the left part
            ans.add(arr[i]);
            i++;
        }

    
        while(i < n && arr[i][0] <= add[1]){ // overlapping handling 
            add[0] = Math.min(arr[i][0],add[0]);
            add[1] = Math.max(arr[i][1],add[1]);
            i++;
        }
        ans.add(add);

        while(i < n){ // remaining adding
            ans.add(arr[i]);
            i++;
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}