import java.util.*;
import java.io.*;

public class Main{
 public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    
     for(int i=0; i<t; i++){
       System.out.println(solution(br.readLine()));
     }
  }
    
  public static String solution(String line){
    Stack<Character> stack = new Stack<Character>();
    boolean check = true;
    for(int i=0; i<line.length(); i++){
        if(line.charAt(i)=='('){
           stack.push(line.charAt(i));
        } else {
           if(stack.empty()){
             check = false;
               break;
           } else {
             stack.pop();
           }
        }
    }
      if(check&&stack.empty()){
         return "YES";
      } else {
         return "NO";
      }
     
  }
}