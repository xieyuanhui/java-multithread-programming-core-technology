package leetcode;

import java.util.Stack;

class Solution {
    public static boolean isValidSerialization(String preorder) {
        if (preorder == null) {
            return true;
        }
        String[] s = preorder.split(",");
        Stack<String> stack = new Stack<>();
        if (s[0].equals("#")) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            String tmp = s[i];
            String top = "";
            if (!stack.isEmpty()) {
                top = stack.peek();
            }
            if (tmp.equals("#") && top.equals("#")) {
                stack.pop();
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
                i = i - 1;
            } else {
                stack.push(tmp);
            }
            printStack(stack);
        }
        return stack.peek().equals("#") && stack.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("1,#"));
    }

    public static void printStack(Stack<String> stack) {
        System.out.print("stack is : ");
        int len = stack.size();
        for (String s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
