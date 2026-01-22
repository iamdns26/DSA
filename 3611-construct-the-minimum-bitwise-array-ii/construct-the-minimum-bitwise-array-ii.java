class Solution {
  public int[] minBitwiseArray(List<Integer> values) {
      int size = values.size();
      int[] output = new int[size];

      for (int idx = 0; idx < size; idx++) {
          int current = values.get(idx);
          // Handle edge scenario
          if (current == 2) {
              output[idx] = -1;
              continue;
          }
          int temp = current;
          int trailing = 0;
          // Count trailing set bits
          while ((temp & 1) != 0) {
              trailing++;
              temp >>= 1;
          }
          int bitToRemove = 1 << (trailing - 1);
          output[idx] = current - bitToRemove;
      }

      return output;
  }
}