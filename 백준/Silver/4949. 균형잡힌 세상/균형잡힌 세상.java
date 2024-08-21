import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String line = br.readLine();
            if(line.equals(".")) {
                break;
            } else {
                System.out.println(solution(line));
            }
            
        }
        
    }
    
    public static String solution(String line) {
        Stack<Character> ps = new Stack<>();
        boolean check = true;
        
        for(int i=0; i<line.length(); i++) {
            char lineAt = line.charAt(i);
            if(lineAt == '(') {
                ps.push(lineAt);
            } else if(lineAt == ')') {
                if(ps.empty()){
                    check = false;
                    break;
                } else {
                    if(ps.peek() == '(') {
                    	ps.pop();
                    } else {
                    	check = false;
                    }
                }
            } else if(lineAt == '[') {
                ps.push(lineAt);
            } else if(lineAt == ']') {
                if(ps.empty()) {
                	check = false;
                    break;
                } else {
                	if(ps.peek() == '[') {
                		ps.pop();
                	} else {
                    	check = false;
                    }
                }
            }
        }
        
        if(ps.empty()&&check) {
            return "yes";
        } else {
            return "no";
        }
    }
}