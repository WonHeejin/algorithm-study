import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(solution(i, 0)+i==n){
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
    
    public static int solution(int i, int result) {
        if (i==0) {
            return result;
        }else{
            result+=i%10;
            i/=10;
            return solution(i, result);
        }
    }
}