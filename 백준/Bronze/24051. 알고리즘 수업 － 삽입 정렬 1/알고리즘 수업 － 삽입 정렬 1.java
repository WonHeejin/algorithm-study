import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(arr, K));
    }
    
    public static int solution(int[] arr, int K) {
    	int count = 0;
    	for(int i=1; i<arr.length; i++) { //두 번째 원소부터 시작
    		int temp = arr[i];//현재 원소
    		int prev = i-1;
    		while(prev>=0 && arr[prev]>temp) { //현재 원소가 앞 원소보다 작으면 반복
    			arr[prev+1] = arr[prev]; //앞 원소와 자리 교체
    			prev--; //앞으로 이동
    			count++;
    			if(count == K) {
    				return arr[prev+1];
    			}
    		}
    		if(arr[prev+1] != temp) {
    			arr[prev+1] = temp; //삽입
    			count++;
    		}
    		if(count == K) {
    			return arr[prev+1];
    		}
    	}
    	return -1;
    }
    
}