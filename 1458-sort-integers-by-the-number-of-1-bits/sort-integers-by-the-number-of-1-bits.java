class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = (Integer.bitCount(arr[i]) << 16) | arr[i];
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] & 0xFFFF;//00000000000000001111111111111111
        }
        return arr;
    }
}