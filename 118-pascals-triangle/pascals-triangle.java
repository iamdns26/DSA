class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>());
        t.get(0).add(1);
        if(n==1) return t;

        List<List<Integer>> temp = generate(n-1);

        List<Integer> l = new ArrayList<>();
        List<Integer> hel = new ArrayList<>(temp.get(temp.size()-1));
        l.add(1);
        for(int i = 0 ; i < hel.size()-1 ; i++){
            l.add(hel.get(i) + hel.get(i+1));
        }
        l.add(1);

        temp.add(l);

        return temp;


    }
}