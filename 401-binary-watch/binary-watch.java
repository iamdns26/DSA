class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int hour = 0; hour < 12; hour++) {
            for(int minute = 0; minute < 60; minute++) {
                int totalOn = Integer.bitCount(hour) + Integer.bitCount(minute);        
                if(totalOn == turnedOn) {
                    String s = hour + ":" + ((minute < 10) ? "0" + minute : minute);
                    res.add(s);
                }
            }
        }
        return res;
    }
}