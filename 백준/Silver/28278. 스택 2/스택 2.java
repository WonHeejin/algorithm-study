import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order) {
                case "1" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "2" :
                    if(stack.empty()) {
                       sb.append("-1"+"\n");
                    } else {
                       sb.append(stack.pop()+"\n");
                    }
                    break;
                case "3" :
                    sb.append(stack.size()+"\n");
                    break;
                case "4" :
                    if(stack.empty()) {
                       sb.append("1"+"\n");
                    } else {
                       sb.append("0"+"\n");
                    }
                    break;
                case "5" :
                    if(stack.empty()) {
                       sb.append("-1"+"\n");
                    } else {
                       sb.append(stack.peek()+"\n");
                    }
                    break;
            }
        }
        System.out.print(sb.toString());
    }
    
}