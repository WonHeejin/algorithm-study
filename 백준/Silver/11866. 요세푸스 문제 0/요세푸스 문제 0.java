import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        System.out.print(solution(queue, K));
    }
    
    public static String solution(Queue<Integer> queue, int K) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        sb.append("<");
        while(!queue.isEmpty()) {
            if(count%K == 0) {
                sb.append(queue.remove());
                if(!queue.isEmpty()) { //마지막이 아닐 경우
                    sb.append(", ");
                }
            } else {
                queue.add(queue.remove());
            }
            count++;
        }
        sb.append(">");   
        return sb.toString();
    }
}