class Solution {
    class Pair{
        String s;
        int count;
        Pair(String s, int count){
            this.s = s;
            this.count = count;
        }
    }
    public int ladderLength(String be, String en, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < wordList.size() ; i++) set.add(wordList.get(i));
        if(!set.contains(en)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(be,1));

        while(q.size() > 0){
            Pair p = q.remove();
            int count = p.count;
            String s = p.s;

            // check this is equat to end
            if(s.equals(en)) return count;

            char[] word = s.toCharArray();

            for(int i = 0 ; i < word.length ; i++){
                char orig = word[i];
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    word[i] = ch;
                    String temp = new String(word);
                    if(set.contains(temp)){
                        q.add(new Pair(temp,count+1));
                        set.remove(temp);
                    }
                }
                word[i] = orig;
            }
        }
        return 0;

    }
}