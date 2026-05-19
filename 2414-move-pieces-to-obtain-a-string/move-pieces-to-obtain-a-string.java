class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {  // Skip '_'
                i++;
            }
            while (j < n && target.charAt(j) == '_') {  // Skip '_'
                j++;
            }

            // If both reached end
            if (i == n && j == n) {
                return true;
            }

            // If one reached end
            if (i == n || j == n) {
                return false;
            }

            // Characters must match
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            char ch = start.charAt(i);

            // 'L' can move only left
            if (ch == 'L' && i < j) {
                return false;
            }

            // 'R' can move only right
            if (ch == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}