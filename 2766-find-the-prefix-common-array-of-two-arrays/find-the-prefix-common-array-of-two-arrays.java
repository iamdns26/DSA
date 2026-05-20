class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;       
        int ans[]=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(A[i]==B[i]){
                map.put(A[i],map.getOrDefault(A[i],0)+2);
                count++;
            }
            else{
                map.put(A[i],map.getOrDefault(A[i],0)+1);
                map.put(B[i],map.getOrDefault(B[i],0)+1);
                if(map.get(A[i])==2){
                    count++;
                }
                if(map.get(B[i])==2){
                    count++;
                }
            }
            ans[i]=count;
        }
        
        
        return ans;
    }
}