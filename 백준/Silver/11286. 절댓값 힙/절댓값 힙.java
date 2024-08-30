import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> abs = new PriorityQueue<Integer>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			} else {
				return Math.abs(o1) - Math.abs(o2); //절대값이 작은 순서대로
			}
		});
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(abs.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(abs.poll());
                }
            } else {
                abs.add(x);
            }
        }
    }
}