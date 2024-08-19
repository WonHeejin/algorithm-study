import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int k = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<k; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }
        while(!stack.empty()) {
            result += stack.pop();
        }
        System.out.print(result);
    }
}