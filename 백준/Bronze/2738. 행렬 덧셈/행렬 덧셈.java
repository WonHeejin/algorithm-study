import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] line = new String[n*2]; //행이 n개인 행렬 2개
        
        for(int i=0; i<n*2; i++) {
            line[i] = br.readLine();
        }
        System.out.print(solution(n, line));
    }
    
    public static String solution(int n, String[] line) {
        StringBuffer sb = new StringBuffer();
        
        for(int j=0; j<n; j++) {
            StringTokenizer a = new StringTokenizer(line[j]); //행렬 a
            StringTokenizer b = new StringTokenizer(line[j+n]); //행렬 b
            while(a.hasMoreTokens()) { //토큰 있으면 true, 없으면 false
                sb.append(Integer.parseInt(a.nextToken())+Integer.parseInt(b.nextToken())+" ");   
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}