import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        int n = 9;
        int max=0, column=0, row=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max<=num) {
                    max = num;
                    column = i+1;
                    row = j+1;
                }
            }
        }
        System.out.print(max+"\n"+column+" "+row);
    }
}