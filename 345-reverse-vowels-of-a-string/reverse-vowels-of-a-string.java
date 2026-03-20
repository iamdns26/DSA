class Solution {
    public boolean isVowel(char y){
       String s = "aeiouAEIOU";
       return s.indexOf(y) != -1;
    }
    public String reverseVowels(String s) {
        char [] arr = s.toCharArray();
        int i = 0 ;
        int j = arr.length-1;

        while(i<j){
            if(isVowel(arr[i])==false) i++;
            if(isVowel(arr[j])==false) j--;
            if(isVowel(arr[i])==true && isVowel(arr[j])==true){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            
            
        }
        return new String(arr);

    }
}