package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by boileryao on 2018/2/14.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class MinStack {
    private int min = Integer.MAX_VALUE;
    private List<Integer> list;

    @LeetCode(id = 155, problemName = "min-stack", level = LeetCode.Level.EASY)
    public MinStack() {
        list = new LinkedList<>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.getMin() == -3;
        minStack.pop();
        assert minStack.top() == 0;
        assert minStack.getMin() == -2;
    }

    public void push(int x) {
        list.add(0, x);
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("top() on an empty stack!");
        }

        int removed = list.remove(0);

        if (removed == min) {
            min = Integer.MAX_VALUE;
            for (int x : list) {
                if (x < min) min = x;
            }
        }
    }

    public int top() {
        if (list.size() <= 0) {
            throw new IllegalStateException("top() on an empty stack!");
        }
        return list.get(0);
    }

    public int getMin() {
        if (list.isEmpty()) {
            throw new IllegalStateException("getMin() on an empty stack!");
        }
        return min;
    }
}
