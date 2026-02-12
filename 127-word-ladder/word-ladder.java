class Solution {
    class Pair{
        String str;
        int val;
        Pair(String str, int val){
            this.str = str;
            this.val = val;
        }

    }
    public int ladderLength(String st, String en, List<String> arr) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < arr.size() ; i++) set.add(arr.get(i));
        if(!set.contains(en)) return 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(st,1));
        while(q.size()>0){
            Pair p = q.remove();
            String str = p.str;
            int count = p.val;
            char[] word = str.toCharArray();
            if(str.equals(en)) return count; // check if end equal

            for(int i = 0 ; i < str.length() ; i++){
                char origi = word[i];
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    word[i] = ch;
                    String newWord = new String(word);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, count + 1));
                        set.remove(newWord);
                    }
                }
                word[i] = origi;
            }
        }
        return 0;
    }
}