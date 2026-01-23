class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        int sorted = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            int c = Long.compare(a[0], b[0]);
            return c != 0 ? c : Long.compare(a[1], b[1]);
        });

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] >= arr[i]) sorted++;
            pq.offer(new long[]{arr[i] + arr[i + 1], i});
        }

        if (sorted == n - 1) return 0;

        int[] prev = new int[n], next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        int remaining = n;
        boolean[] removed = new boolean[n];

        while (remaining > 1) {
            long[] cur = pq.poll();
            if (cur == null) break;
            long sum = cur[0];
            int left = (int) cur[1];
            int right = next[left];

            if (right == n || removed[left] || removed[right] || arr[left] + arr[right] != sum)
                continue;

            int pre = prev[left];
            int nxt = next[right];

            if (arr[left] <= arr[right]) sorted--;
            if (pre != -1 && arr[pre] <= arr[left]) sorted--;
            if (nxt != n && arr[right] <= arr[nxt]) sorted--;

            arr[left] += arr[right];
            removed[right] = true;
            remaining--;

            if (pre == -1) {
                prev[left] = -1;
            } else {
                pq.offer(new long[]{arr[pre] + arr[left], pre});
                if (arr[pre] <= arr[left]) sorted++;
            }

            if (nxt == n) {
                next[left] = n;
            } else {
                prev[nxt] = left;
                next[left] = nxt;
                pq.offer(new long[]{arr[left] + arr[nxt], left});
                if (arr[left] <= arr[nxt]) sorted++;
            }

            if (sorted == remaining - 1) return n - remaining;
        }

        return n;
    }
}