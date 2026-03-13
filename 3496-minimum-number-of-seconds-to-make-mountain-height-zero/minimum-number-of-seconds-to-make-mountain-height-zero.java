class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[0] ,b[0]));
        for(int i = 0;i<workerTimes.length;i++){
            pq.add(new long[]{workerTimes[i],2, workerTimes[i]});
        }

        long ans = 0;
        while(mountainHeight != 0) {
            long cur[] = pq.poll();
            ans = cur[0];
            pq.add(new long[]{cur[0] + (cur[1] * cur[2]), cur[1]+1, cur[2]});
            mountainHeight--;
        }
        return ans;
    }
}