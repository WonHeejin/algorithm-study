import java.io.*;
import java.util.*;

public class Main{
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        
        //Queue 생성
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }
        
        System.out.print(solution(queue));
    }
    public static int solution(Queue<Integer> queue) {
        while(queue.size()>=2) {
            queue.remove();
            queue.add(queue.remove());
        }
        return queue.peek();
    }
}