import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];
        
        //배열에 담기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        
        solution(X, visitors);
        
    }
    
    public static void solution(int X, int[] visitors) {
        //n-x까지
        int sum = 0;
        int max = 0;
        int count = 0;
        for(int i=0; i<=visitors.length-X; i++) {
            if(i==0) {
                for(int j=0; j<X; j++) {
                    sum+=visitors[j];
                }
                max = sum;
                count = 1;
            }else {
                sum = sum-visitors[i-1]+visitors[i+X-1];
                if(max != 0 &&sum == max) {
                    count++;
                } else if(sum>max) {
                	max = sum;
                	count = 1;
                }
            }
            
        }
        if(max == 0) {
            System.out.print("SAD");
        } else {
            System.out.print(max + "\n" + count);
        }
    }
}