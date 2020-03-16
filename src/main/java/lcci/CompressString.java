package lcci;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。字符串长度在[0, 50000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 */
public class CompressString {
    public String compressString(String s) {
        StringBuilder builder = new StringBuilder(26 * 4);  // a999b999...z999
        int idx = 0;
        while (idx < s.length()) {
            char current = s.charAt(idx++);
            int count = 1;
            while (idx < s.length() && s.charAt(idx) == current) {
                idx++;
                count++;
            }
            builder.append(current).append(count);
            if (builder.length() >= s.length()) {
                return s;
            }
        }
        return builder.toString();
    }
}
