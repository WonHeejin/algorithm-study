import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int papers = Integer.parseInt(br.readLine());
        int black[][] = new int [papers][2];
        int total = 0;
        
        for(int i=0; i<papers; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            black[i][0] = Integer.parseInt(st.nextToken());
            black[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(papers, black));
    }
    
    public static int solution(int papers, int[][] black) {
        boolean[][] white = new boolean[101][101];
        int total = 0;
        for(int i=0; i<papers; i++) {
            int x = black[i][0];
            int y = black[i][1];
            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    if(!white[j][k]) {
                        white[j][k] = true;
                        ++total;
                    }
                }
            }    
        }
        return total;
    }
}