package STACK_2;

import java.util.Stack;
import java.lang.StringBuilder;

public class UnixPathSimplifier {

    public static void main(String[] args) {
        String path = "/home//foo/../bar/";
        String result = Simplify(path);
        System.out.println(result);  // Expected output: /home/bar
    }

    public static String Simplify(String str) {
        Stack<String> s = new Stack<>();
        String res = "/";
        int len = str.length();

        for (int i = 0; i < len; i++) {
            // Skip multiple slashes
            while (i < len && str.charAt(i) == '/') {
                i++;
            }

            String dir = "";
            // Collect directory name until next slash
            while (i < len && str.charAt(i) != '/') {
                dir += str.charAt(i);
                i++;
            }

            // Process directory name
            if (dir.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else if (dir.equals(".")) {
                // Current directory, do nothing
                continue;
            } else if (dir.length() != 0) {
                s.push(dir);
            }
        }

        // Reverse the stack to get correct order
        Stack<String> str1 = new Stack<>();
        while (!s.isEmpty()) {
            str1.push(s.pop());
            
        }

        //Build the final path string
        while(str1.isEmpty()){
            return "/";
        }

        // Build the final path string
        StringBuilder sb = new StringBuilder();
        while(!str1.isEmpty()){
            sb.append("/").append(str1.pop());
        }
        return sb.toString();
    }
}


