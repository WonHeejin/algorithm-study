import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0; //가장 가까운 수
        int diff = 0; //m과 세 개의 숫자 합의 차이
        //카드 숫자 저장
        int[] cards = new int[n]; 
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st2.nextToken());
        }
        
        //3개씩 더함 + 이미 더한 것은 안더해도 됨 
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = cards[i]+cards[j]+cards[k];
                    int abs = Math.abs(m-sum); //합이 m을 넘지 않음
                    //첫번째인 경우
                    if(i==0&&j==1&&k==2) {
                        result = sum;
                        diff = abs;
                    } else {
                        if(sum<=m && diff>=abs) {
                            result = sum;
                            diff = abs;
                        }
                    }
                }
            }
        }
        System.out.print(result);
    }
}