class Solution {
    public int longestBalanced(String s) {
        int a=0;
        char[] c = s.toCharArray();
        //1-char
        for(char x='a'; x<='c'; x++){
            a=Math.max(a, get1(c, x));
        }
        //2-char
        a=Math.max(Math.max(a, get2(c,'a','b', a)), 
                   Math.max(get2(c,'a','c', a), get2(c,'b','c', a)));
        //3-char
        a=Math.max(a, get3(c, a));
        return a;
    }
    private int get3(char[] c, int max){
        int a=max, t, pow=1_000_000;
        long v=1_000_001_000_000L;
        Map<Long,Integer> map = new HashMap<>();
        map.put(v, -1);
        for(int i=0; i<c.length; i++){
            if(c[i]=='a')v+=pow+1;
            else if(c[i]=='b')v-=pow;
            else v--;

            if(map.containsKey(v)){
                t=i-map.get(v);
                if(a<t)a=t;
            }else map.put(v, i);
        }
        return a;
    }
    private int get2(char[] c, char x, char y, int max){
        int clear = -1;
        int a=0, v=c.length, t;
        int[] map = new int[(c.length<<1)+1];
        Arrays.fill(map, -2); map[v]=-1;

        for(int i=0; i<c.length; i++){
            if(c[i]!=x&&c[i]!=y){
                clear = i; v=c.length;
                map[v]=clear;
            }else{
                if(c[i]==x)v++;
                else v--;

                if(map[v]<clear) map[v]=i;
                else if(v==c.length){
                    t=i-clear;
                    if(a<t)a=t;
                }else{
                    t=i-map[v];
                    if(a<t)a=t;
                }
            }
        }
        return a;
    }
    private int get1(char[] c, char x){
        int a=0, b=0;
        for(char y:c){
            if(x==y)b++;
            else if(b>0){
                if(a<b)a=b;
                b=0;
            }
        }
        return Math.max(a, b);
    }
}