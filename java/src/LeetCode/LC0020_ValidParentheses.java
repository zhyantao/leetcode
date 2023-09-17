package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC0020_ValidParentheses {

    public boolean isValid(String s) {

        char[] chs = s.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : chs) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
                continue;
            }
            if (stack.peekFirst() == '(' && c == ')') {
                stack.removeFirst();
            } else if (stack.peekFirst() == '[' && c == ']') {
                stack.removeFirst();
            } else if (stack.peekFirst() == '{' && c == '}') {
                stack.removeFirst();
            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }

}
