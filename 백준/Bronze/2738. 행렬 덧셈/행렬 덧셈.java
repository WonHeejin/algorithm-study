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
        StringBuffer sb = new StringBuffer();
        int[][] a = new int[n][m];
        
        for(int i=0; i<2; i++) { //두 개의 행렬을 받음
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    a[j][k] += Integer.parseInt(st.nextToken());
                    if(i==1) sb.append(a[j][k] + " ");
                }
                if(i==1) sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}