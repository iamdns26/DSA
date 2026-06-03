class Solution {
    int res;
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        res=3000001;
        int les=lst[0]+ld[0];
        int wes=wst[0]+wd[0];
        for(int i=0;i<lst.length;i++){
            les=Math.min(les,lst[i]+ld[i]);
        }
        for(int i=0;i<wst.length;i++){
            res=Math.min(res,Math.max(les,wst[i])+wd[i]);
            wes=Math.min(wes,wst[i]+wd[i]);
        }
        for(int i=0;i<lst.length;i++)res=Math.min(res,Math.max(wes,lst[i])+ld[i]);
        return res;
    }
}