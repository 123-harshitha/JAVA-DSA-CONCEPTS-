package STACK_2;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str1 = "3[b2[ca]]";
        String result = DecoderString(str1);
        System.out.println(result);  // Expected: bcacabcacabcaca
    }

    public static String DecoderString(String str1) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currStr = "";
        int num = 0;

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);

            if (Character.isDigit(ch)) {
                // Build number (handle multiple digits)
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                stringStack.push(currStr);
                countStack.push(num);
                // Reset for inner string
                currStr = "";
                num = 0;
            } else if (ch == ']') {
                int repeat = countStack.pop();
                String prevStr = stringStack.pop();

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    sb.append(currStr);
                }

                // Append repeated string to previous
                currStr = prevStr + sb.toString();
            } else {
                currStr += ch;
            }
        }

        return currStr;
    }
}
