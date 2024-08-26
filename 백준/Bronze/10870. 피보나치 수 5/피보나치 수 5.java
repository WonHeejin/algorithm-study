import java.io.*;
import java.util.*;

public class Main{
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        System.out.print(solution(0,1,0));
    }
    
    public static int solution(int a, int b, int count) {
        if(count == n) {
            return a;
        } else {
        	count++;
            return solution(b, a+b, count);    
        }
    }
}