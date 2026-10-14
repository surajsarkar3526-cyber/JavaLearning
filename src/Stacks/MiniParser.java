package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParser {
    static class NestedInteger {
        private Integer value;
        private List<NestedInteger> list;

        public NestedInteger() {
            list = new ArrayList<>();
        }
        public NestedInteger(int value) {
            this.value = value;
        }
        public boolean isInteger() {
            return value != null;
        }
        public Integer getInteger() {
            return value;
        }
        public void add(NestedInteger ni) {
            list.add(ni);
        }
        public List<NestedInteger> getList() {
            return list;
        }
        @Override
        public String toString() {
            if (isInteger()) {
                return value.toString();
            }
            return list.toString();
        }
    }
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;
        int number = 0;
        int sign = 1;
        boolean readingNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                NestedInteger list = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(list);
                }
                stack.push(list);
                current = list;
            }
            else if (ch == '-') {
                sign = -1;
            }
            else if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
                readingNumber = true;
            }
            else if (ch == ',' || ch == ']') {
                if (readingNumber) {
                    stack.peek().add(
                            new NestedInteger(number * sign)
                    );
                    number = 0;
                    sign = 1;
                    readingNumber = false;
                }
                if (ch == ']') {
                    current = stack.pop();
                }
            }
        }
        return current;
    }

    public static void main(String[] args) {
        MiniParser parser = new MiniParser();
        NestedInteger result = parser.deserialize("[123,[456,[789]]]");
        System.out.println(result);
    }
}
