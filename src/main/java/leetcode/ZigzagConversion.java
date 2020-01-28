package leetcode;

public class ZigzagConversion {
    @LeetCode(id = 6, problemName = "zigzag-conversion", level = LeetCode.Level.MEDIUM)
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        int zigzagSize = (numRows << 1) - 2;
        int rounds = s.length() / zigzagSize;
        if (s.length() % zigzagSize != 0) rounds += 1;

        char[] result = new char[s.length()];
        int appended = 0;
        for (int row = 0; row < numRows; row++) {
            for (int round = 0; round < rounds; round++) {
                int roundBase = round * zigzagSize;
                int zigIndex = roundBase + row;
                if (zigIndex >= s.length()) break;
                result[appended++] = s.charAt(zigIndex);
                if (row > 0 && row < numRows - 1) {
                    int zagIndex = roundBase + zigzagSize - row;
                    if (zagIndex >= s.length()) break;
                    result[appended++] = s.charAt(zagIndex);
                }
            }
        }
        return new String(result);
    }
}
