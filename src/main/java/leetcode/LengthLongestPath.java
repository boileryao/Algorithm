package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by boileryao on 2017/2/22.
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        String a = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String b = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        System.out.println(new LengthLongestPath().lengthLongestPath(a));
        System.out.println(new LengthLongestPath().lengthLongestPath(b));
    }

    @SuppressWarnings("ConstantConditions")
    @LeetCode(id = 388, problemName = "longest-absolute-file-path", level = LeetCode.Level.MEDIUM)
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}

