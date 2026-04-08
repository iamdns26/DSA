class Solution {
    public int maxEvents(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, n = arr.length;
        int d = 0, count = 0;

        while (i < n || !pq.isEmpty()) {

            if (pq.isEmpty())   d = arr[i][0]; 
            

            while (i < n && arr[i][0] == d) {
                pq.offer(arr[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < d) pq.poll();
            

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            
            d++;
        }
        return count;
    }
}