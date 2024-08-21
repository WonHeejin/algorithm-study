import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        System.out.print(solution(n, line));
    }
    
    public static String solution(int n, String line) {
        String[] st = line.split(" ");
        Stack<Integer> stack = new Stack<>(); //한명씩만 설 수 있는 공간
        int count = 1;
        //현재 줄 서있는 곳 - 작은 숫자부터 내보내기
        for(int i=0; i<n; i++) {
            int number = Integer.parseInt(st[i]);
            if(number == count) {
                count++;
            } else {
                if(!stack.empty()&&stack.peek()==count){
                    stack.pop();
                    count++;
                    i--;
                } else {
                    stack.push(number);    
                }
            }
        }
        
        while(count <= n && !stack.empty()) {
            if(stack.peek() == count){
                stack.pop();
                count++;
            } else {
                return "Sad";
            }
        }
        
        if(stack.empty()) {
            return "Nice";
        } else {
            return "Sad";
        }
    }
}