class Solution {
    public class Pair{
        int key;
        int freq;
        Pair(int key, int freq){
            this.key = key;
            this.freq = freq;
        }

    }
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele : arr){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }
            else map.put(ele,1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        for(int key : map.keySet()){
            int freq = map.get(key);
            pq.add(new Pair(key,freq));
        }
        int x = n;
        int count = 0;
        while(x>n/2){
            Pair p = pq.remove();
            x-=p.freq;
            count++;
        }
        return count;
    }
}