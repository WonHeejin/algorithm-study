import java.io.*;
import java.util.*;

public class Main{
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<count; i++) {
			StringTokenizer order = new StringTokenizer(br.readLine());
			switch(order.nextToken()) {
				case "push" :
					deque.offer(Integer.parseInt(order.nextToken()));
					break;
				case "pop" :
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}else {
						sb.append(deque.poll()+"\n");
					}
					
					break;
				
				case "size" :
					sb.append(deque.size()+"\n");
					break;
					
				case "empty" :
					if(deque.isEmpty()) {
						sb.append(1+"\n");
					}else {
						sb.append(0+"\n");
					}
					break;
					
				case "front" :
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}else {
						sb.append(deque.getFirst()+"\n");
					}
					break;
					
				case "back" :
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}else {
						sb.append(deque.peekLast()+"\n");
					}
					break;
			}
		}
        System.out.print(sb.toString());
	}
}